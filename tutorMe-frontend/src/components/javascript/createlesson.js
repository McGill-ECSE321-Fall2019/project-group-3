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
            courseOps: [],
            roomOps: [],
            studentOps: [],
            tutorOps: [],
            map : null,
            form: {
                course: null,
                endTime: "",
                room: null,
                startTime: "",
                student: null,
                tutor: null,
                lessonId: "1"
            },
        }
    },
    mounted: async function getAllData() {
        this.checkIfForUpdate();
        var self = this;
        self.map = new Map(); 
        self.map.set("", null);
        axios.all([this.getAllStudents(), this.getAllTutors(), this.getAllCourse(), this.getAllRooms()])
            .then(axios.spread(function (students, tutors, courses, rooms) {
                students.data.forEach(obj => {
                    if (obj != null && obj.email != null && obj.email != undefined) {
                        self.studentOps.push(obj.email);
                        self.map.set(obj.email, obj);
                    }
                });
                tutors.data.forEach(obj => {
                    if (obj != null && obj.email != null && obj.email != undefined) {
                        self.tutorOps.push(obj.email);
                        self.map.set(obj.email, obj);
                    }
                });
                courses.data.forEach(obj => {
                    if (obj.courseName != null && obj.courseName != undefined && obj.courseName != "") {
                        self.courseOps.push(obj.courseName);
                        self.map.set(obj.courseName, obj);
                    }
                });
                rooms.data.forEach(obj => {
                    if (obj.room_id != null && obj.room_id != undefined && obj.size != null &&
                        obj.size!=undefined && obj.size!="") {
                        self.roomOps.push("#"+obj.room_id+"-"+obj.size);
                        self.map.set("#"+obj.room_id+"-"+obj.size, obj);
                    }
                });
            }));
            console.log("checking");
    },
    methods: {
        async onSubmit(evt) {
            evt.preventDefault();
            let self = this;    
            if(self.form.course!=null && self.form.course!=undefined){
                self.form.course = self.map.get(self.form.course);  
            } 
            if(self.form.room!=null && self.form.room!=undefined){
                self.form.room = self.map.get(self.form.course); 
            } 
            if(self.form.student!=null && self.form.student!=undefined){
                self.form.student = self.map.get(self.form.student); 
            } 
            if(self.form.tutor!=null && self.form.tutor!=undefined){
                self.form.tutor = self.map.get(self.form.tutor); 
            } 
            await AXIOS.post('/api/lesson', self.form).then(resp => {
                alert("Lesson created! Redirecting");
                this.$router.push("Lesson");
            }).catch(e => {
                alert("error: " + e);
            });
        },
        getAllStudents: function () {
            return AXIOS.get('/api/student/getall');
        },
        getAllTutors: function () {
            return AXIOS.get('/api/tutor/getall');
        },
        getAllCourse: function () {
            return AXIOS.get('/api/course/getall');
        },
        getAllRooms: function () {
            return AXIOS.get('/api/room/getall');
        },
        checkIfForUpdate: async function () {
            if(this.$route.query.update!=null && this.$route.query.update!=undefined){
                //this component is for updating, preload data. 
                console.log("Create Lesson is for Update Lesson :O")
                let lessonId = this.$route.query.update; 
                await AXIOS.get('/api/lesson?lessonId='+lessonId).then(resp => {
                    let respData = resp.data; 
                    this.form = respData;
                    this.update = true;
                    this.form.student = this.form.student.email;
                    this.form.tutor = this.form.tutor.email; 
                    this.$forceUpdate();
                }).catch(e => function(e){
                    console.log(e);
                });
            }
        }
    }
}
