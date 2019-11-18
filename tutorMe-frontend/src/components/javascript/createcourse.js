import axios from 'axios';
import config from '../../../config/index';

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
            universityOps: [],
            subjectOps: [],
            map: null,
            form: {
                subject: null,
                courseName: null
            },
        }
    },
    mounted: async function getAllData() {
        this.checkIfForUpdate();
        var self = this;
        self.map = new Map();
        axios.all([this.getAllUniversities(), this.getAllSubjects()])
            .then(axios.spread(function (universities, subjects) {
                universities.data.forEach(obj => {
                    if (obj.university_name != "" && obj.university_name != null && obj.university_name != undefined) {
                        self.universityOps.push(obj.university_name);
                        self.map.set(obj.university_name, obj);
                    }
                });
                subjects.data.forEach(obj => {
                    if (obj.subject_name != "" && obj.subject_name != null && obj.subject_name != undefined) {
                        self.subjectOps.push(obj.subject_name);
                        self.map.set(obj.subject_name, obj);
                    }
                });
            }));
    },
    methods: {
        async onSubmit(evt) {
            var self = this;
            evt.preventDefault()
            if (self.form.subject != null && self.form.subject != undefined && self.form.subject != "") {
                self.form.subject = self.map.get(self.form.subject);
            }
            await AXIOS.post('/api/course', self.form).then(resp => {
                console.log("sent req");
            }).catch(e => {
                console.log("error: " + e);
            });
            alert("Course created!");
            this.$router.push("Course");
        },
        getAllUniversities: function () {
            return AXIOS('/api/university/getall');
        },
        getAllSubjects: function () {
            return AXIOS('/api/subject/getall');
        },
        checkIfForUpdate: async function () {
            if(this.$route.query.update!=null && this.$route.query.update!=undefined){
                //this component is for updating, preload data. 
                console.log("its working again, hallelujah");
                let courseyBoi = this.$route.query.update; 
                await AXIOS.get('/api/course?courseName='+courseyBoi).then(resp => {
                    let respData = resp.data; 
                    this.form = respData;
                    this.update = true;
                    this.$forceUpdate();
                }).then(() => AXIOS.delete('/api/course?courseName='+courseyBoi))
                    .catch(e => function(e){
                    console.log(e);
                });
            }
        }
    }
}