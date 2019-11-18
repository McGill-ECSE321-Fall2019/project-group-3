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
            hasCourses: false,
            subjects: null,
            hasSubjects: false
        }
    },
    mounted: async function() {
        console.log("mounty boi");
        AXIOS.get('/api/course/getall').then((response => {
            this.courses = response.data; 
            console.log("made call");
            console.dir(this.courses); 
            if(this.courses != null && this.courses != undefined 
                && this.courses.length > 0) this.hasCourses = true; 
        })).then(
        AXIOS.get('/api/subject/getall').then((response => {
            this.subjects = response.data;
            console.log("made call");
            console.dir(this.subjects);
            if(this.subjects != null && this.subjects != undefined && this.subjects.length > 0) this.hasSubjects = true;
        }))).catch(e => function(e){
            alert("Error!" + e); 
        })
    }, 
    methods: {
        deleteCourse: async function(deleteId) {
            await AXIOS.delete('/api/course?courseName='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                console.dir(this.subjects);
                this.subjects.forEach(subject => {
                if(subject.courses!=null && subject.courses!=undefined){
                for (let i = subject.courses.length - 1; i >= 0; i--){
                    if(subject.courses[i].courseName === deleteId) {
                        console.log("hello boi");
                        subject.courses.splice(i, 1);
                    }
                }  }
                })

                if(this.courses.length===0) this.hasCourses = false; 
            }))
        },
        deleteSubject: async function(deleteId) {
            await AXIOS.delete('/api/subject?subjectName='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.subjects.length - 1; i>=0; i--){
                    if(this.subjects[i].subject_name === deleteId){
                        this.subjects.splice(i, 1);
                    }
                }

                if(this.subjects.length===0) this.hasSubjects = false; 
            }))
        }
    }
}
