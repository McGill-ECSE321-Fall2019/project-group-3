import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'https://cors-anywhere.herokuapp.com/' + 'http://' + config.dev.backendHost;

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
            form: {
                course: "null",
                endTime: "",
                room: null,
                startTime: "",
                student: null,
                tutor: null
            },
        }
    },
    mounted: async function getAllData() {
        var self = this;
        axios.all([this.getAllStudents(), this.getAllTutors(), this.getAllCourse(), this.getAllRooms()])
            .then(axios.spread(function (students, tutors, courses, rooms) {
                students.data.forEach(obj => {
                    if (obj.user != null && obj.user.firstName != null && obj.user.firstName != undefined) {
                        self.studentOps.push(obj.user.firstName);
                    }
                });
                tutors.data.forEach(obj => {
                    if (obj.user != null && obj.user.firstName != null && obj.user.firstName != undefined) {
                        self.tutorOps.push(obj.user.firstName);
                    }
                });
                courses.data.forEach(obj => {
                    if (obj.courseName != null && obj.courseName != undefined && obj.courseName != "") {
                        self.courseOps.push(obj.courseName);
                    }
                });
                rooms.data.forEach(obj => {
                    if (obj.room_id != null && obj.room_id != undefined && obj.size != null &&
                        obj.size!=undefined && obj.size!="") {
                        self.roomOps.push("#"+obj.room_id+"-"+obj.size);
                    }
                });
            }));
            console.dir(self.roomOps); 
    },
    methods: {
        saveSelectionAndReset(e) {
            let val = e.target.value;
            if (val) {
              this.optionVal = val;
            }
            e.target.value = "";
          },
        onSubmit(evt) {
            evt.preventDefault();
            console.dir(this.form);
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