import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl =  'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});

export default {
    data() {
        return {
            lessons: null,
            privateLessons:[],
            groupLessons:[],
            hasLessons: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/lesson/getall').then((response => {
            this.lessons = response.data; 
            console.log("made call");
            console.dir(this.lessons); 
            if(this.lessons != null && this.lessons != undefined && this.lessons.length > 0){
               this.hasLessons = true; 
               for(let i = 0; i < this.lessons.length; i++){
                if(this.lessons[i].student != null && this.lessons[i].student != undefined &&this.lessons[i].student.length > 7){
                    this.groupLessons.push(this.lessons[i]);
                }
                else{
                    this.privateLessons.push(this.lessons[i]);
                }
            }
            console.dir(this.privateLessons); 
            console.dir(this.groupLessons); 

        }
    }))
    }, 
    methods: {
        deleteLesson: async function(deleteId) {
            await AXIOS.delete('/api/lesson/delete?lessonId='+deleteId).then((response => {
                console.log("i deleted the element!"); 

                for(let i = this.lessons.length - 1; i>=0; i--){
                    if(this.lessons[i].lessonId === deleteId){
                        this.lessons.splice(i, 1);
                    }
                }
                
                for(let i = this.privateLessons.length - 1; i>=0; i--){
                    if(this.privateLessons[i].lessonId === deleteId){
                        this.privateLessons.splice(i, 1);
                    }
                }
                for(let i = this.groupLessons.length - 1; i>=0; i--){
                    if(this.groupLessons[i].lessonId === deleteId){
                        this.groupLessons.splice(i, 1);
                    }
                }

                if(this.lessons.length===0) this.hasLessons = false; 
            }))
        }, updateLesson: async function(lessonId) {
            await AXIOS.get('/api/lesson?lessonId='+lessonId).then(response => {
                response = response.data;
                this.$router.push({
                    name: 'CreateLesson',
                    query: {
                        update: lessonId
                    }
                })
            })            
        }
    }
}
