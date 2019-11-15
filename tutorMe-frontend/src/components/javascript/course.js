import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});

export default {
    data() {
        return {
            courses: null,
            hasCourses: false
        }
    },
    mounted: async function() {
        AXIOS.get('/api/course/getall').then((response => {
            this.courses = response.data; 
            console.log("made call");
            console.dir(this.courses); 
            if(this.courses != null && this.courses != undefined 
                && this.courses.length > 0) this.hasCourses = true; 
        }))
    }, 
    methods: {
        deleteCourse: async function(deleteId) {
            await AXIOS.delete('/api/course/delete?courseName='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.courses.length - 1; i>=0; i--){
                    if(this.courses[i].courseName === deleteId){
                        this.courses.splice(i, 1);
                    }
                }

                if(this.courses.length===0) this.hasCourses = false; 
            }))
        }
    }
}
