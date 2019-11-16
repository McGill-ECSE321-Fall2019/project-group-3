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
            tutors: null,
            hasTutors: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/tutor/getall').then((response => {
            this.tutors = response.data; 
            console.log("made call");
            console.dir(this.tutors); 
            if(this.tutors != null && this.tutors != undefined 
                && this.tutors.length > 0) this.hasTutors = true; 
        }))
    }, 
    methods: {
        deleteTutor: async function(deleteId) {
            await AXIOS.delete('/api/tutor/delete?tutorId='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.tutors.length - 1; i>=0; i--){
                    if(this.tutors[i].email === deleteId){
                        this.tutors.splice(i, 1);
                    }
                }

                if(this.tutors.length===0) this.hasTutors = false; 
            }))
        }
    }
}
