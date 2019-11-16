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
            universities: null,
            hasUniversities: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/university/getall').then((response => {
            this.universities = response.data; 
            console.dir(this.universities); 
            if(this.universities != null && this.universities != undefined 
                && this.universities.length > 0) this.hasUniversities = true; 
        }))
    }, 
    methods: {
        deleteUniversity: async function(deleteId) {
            await AXIOS.delete('/api/university/delete?universityName='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.universities.length - 1; i>=0; i--){
                    if(this.universities[i].university_name === deleteId){
                        this.lessons.splice(i, 1);
                    }
                }

                if(this.universities.length===0) this.hasUniversities = false; 
            }))
        }, updateUniversity: async function(universityName) {
            await AXIOS.get('/api/university?universityName='+universityName).then(response => {
                response = response.data;
                this.$router.push({
                    name: 'CreateUniversity',
                    query: {
                        update: universityName
                    }
                })
            })            
        }
    }
}
