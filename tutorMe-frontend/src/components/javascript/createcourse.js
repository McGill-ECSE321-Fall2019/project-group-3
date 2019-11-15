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
            universityOps: [],
            subjectOps: [],
            form: {
                university: null,
                subject: null,
                name: null
            },
        }
    },
    mounted: async function getAllData() {
        var self = this;
        axios.all([this.getAllUniversities(), this.getAllSubjects()])
            .then(axios.spread(function (universities, subjects) {
                universities.data.forEach(obj => {
                    if (obj.university_name != "" && obj.university_name != null && obj.university_name != undefined) {
                        console.log("test");
                        self.universityOps.push(obj.university_name);
                    }
                });
                console.log(self.universityOps);
                subjects.data.forEach(obj => {
                    if (obj.subject_name != "" && obj.subject_name != null && obj.subject_ame != undefined) {
                        self.subjectOps.push(obj.subject_name);
                    }
                });
            }));
    },
    methods: {
        onSubmit(evt) {
            evt.preventDefault()
            console.dir(this.form);
        },
        getAllUniversities: function () {
            return AXIOS('/api/university/getall');
        },
        getAllSubjects: function () {
            return AXIOS('/api/subject/getall');
        },
    }
}