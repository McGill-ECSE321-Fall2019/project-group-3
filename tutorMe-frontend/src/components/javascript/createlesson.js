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
        var self = this;
        self.map = new Map(); 
        axios.all([this.getAllStudents(), this.getAllTutors(), this.getAllCourse(), this.getAllRooms()])
            .then(axios.spread(function (students, tutors, courses, rooms) {
                students.data.forEach(obj => {
                    if (obj.user != null && obj.user.firstName != null && obj.user.firstName != undefined) {
                        self.studentOps.push(obj.user.firstName);
                        self.map.set(obj.user.firstName, obj);
                    }
                });
                tutors.data.forEach(obj => {
                    if (obj.user != null && obj.user.firstName != null && obj.user.firstName != undefined) {
                        self.tutorOps.push(obj.user.firstName);
                        self.map.set(obj.user.firstName, obj);
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
            console.dir(self.roomOps); 
    },
    methods: {
        onSubmit(evt) {
            evt.preventDefault();
            let self = this;    
            if(self.form.course!=null && self.form.course!=undefined && self.form.room!=""){
                self.form.course = self.map.get(self.form.course);  
            } 
            if(self.form.room!=null && self.form.room!=undefined && self.form.room!=""){
                self.form.room = self.map.get(self.form.course); 
            } 
            if(self.form.student!=null && self.form.student!=undefined){
                self.form.student = self.map.get(self.form.student); 
            } 
            if(self.form.tutor!=null && self.form.tutor!=undefined && self.form.tutor!=""){
                self.form.tutor = self.map.get(self.form.tutor); 
            } 
            AXIOS.post('/api/lesson', self.form).then(resp => {
                console.log("sent req");
            }).catch(e => {
                console.log("error: " + e);
            });
        },
        getAllStudents: function () {
            return AXIOS('/api/student/getall');
        },
        getAllTutors: function () {
            return AXIOS('/api/tutor/getall');
        },
        getAllCourse: function () {
            return AXIOS('/api/course/getall');
        },
        getAllRooms: function () {
            return AXIOS('/api/room/getall');
        },
    }
}