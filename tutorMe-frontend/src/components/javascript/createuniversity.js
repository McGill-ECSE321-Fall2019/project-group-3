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
            update: false,
            subjectOps: [],
            map : null,
            form: {
                subjects: [], 
                university_name: ""
            },
        }
    },
    mounted: async function getAllData() {
        this.checkIfForUpdate();
        var self = this;
        self.map = new Map(); 
        AXIOS.get('api/subject/getall').then(response => {
            let subjectObj = response.data; 
            subjectObj.forEach(sub => {
                this.subjectOps.push(sub.subject_name);
                self.map.set(sub.subject_name, sub);
            });
            console.dir(this.subjectOps);
        });
    },
    methods: {
        onSubmit(evt) {
            evt.preventDefault();
            let self = this;    
            if(self.form.subjects!=null && self.form.subjects!=undefined && self.form.subjects!=""){
                let tempArr = []; 
                self.form.subjects.forEach(subName => {
                tempArr.push(self.map.get(subName))}); 
                self.form.subjects = []; 
                tempArr.forEach(x => self.form.subjects.push(x)); 
            } 
            AXIOS.post('/api/university', self.form).then(resp => {
                alert("University created! Redirecting");
                this.$router.push("University");
            }).catch(e => {
                console.log("error: " + e);
            });
        },  checkIfForUpdate: async function () {
            if(this.$route.query.update!=null && this.$route.query.update!=undefined){
                //this component is for updating, preload data. 
                console.log("its working again, hallelujah");
                let uniBoi = this.$route.query.update; 
                await AXIOS.get('/api/university?universityName='+uniBoi).then(resp => {
                    let respData = resp.data; 
                    this.form = respData;
                    this.update = true;
                    this.$forceUpdate();
                }).then(() => AXIOS.delete('/api/university/delete?universityName='+uniBoi))
                    .catch(e => function(e){
                    console.log(e);
                });
            }
        }
    }
}