import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'https://cors-anywhere.herokuapp.com/' + 'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});

export default {
    data() {
        return {
            subjects: null,
            hasSubjects: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/subject/getall').then((response => {
            this.subjects = response.data; 
            console.log("made call");
            console.dir(this.subjects); 
            if(this.subjects != null && this.subjects != undefined 
                && this.subjects.length > 0) this.hasSubjects = true; 
        }))
    }, 
    methods: {
        deleteSubject: async function(deleteId) {
            await AXIOS.delete('/api/subject/delete?subjectName='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.subjects.length - 1; i>=0; i--){
                    if(this.subjects[i].subjectName === deleteId){
                        this.subjects.splice(i, 1);
                    }
                }

                if(this.subjects.length===0) this.hasSubjects = false; 
            }))
        }
    }
}
