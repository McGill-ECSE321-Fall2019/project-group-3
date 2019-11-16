import axios from 'axios';
import config from '../../../config/index';
import router from 'vue-router';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'http://' + config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});

export default {
    data() {
        return {
            subjectOps: [],
            map : null,
            form: {
                subjects: [], 
                university_name: ""
            },
        }
    },
    mounted: async function getAllData() {
        var self = this;
        self.map = new Map(); 
        AXIOS.get('api/subject/getall').then(response => {
            let studentsObj = response.data; 
            subjectOps.push(studentsObj.subject_name); 
            self.map.set(studentsObj.subject_name, studentsObj);
        });
    },
    methods: {
        onSubmit(evt) {
            evt.preventDefault();
            let self = this;    
            if(self.form.subjects!=null && self.form.subjects!=undefined && self.form.subjects!=""){
                let tempArr = []; 
                self.form.subjects.forEach(subName => {tempArr.push(self.map.get(subName))}); 
                self.form.subjects = []; 
                tempArr.forEach(x => self.form.subjects.push(x)); 
            } 
            AXIOS.post('/api/university', self.form).then(resp => {
                alert("University created! Redirecting");
                this.$router.push("University");
            }).catch(e => {
                console.log("error: " + e);
            });
        }
    }
}