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
            students: null,
            hasStudents: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/student/getall').then((response => {
            this.students = response.data;
            console.log("made call");
            console.dir(this.students);
            if(this.students != null && this.students != undefined
                && this.students.length > 0) this.hasStudents = true;
        }))
    },
    methods: {
        deleteStudent: async function(deleteId) {
            await AXIOS.delete('/api/student/delete?emailAddress='+deleteId).then((response => {
                console.log("I deleted the element!");

                for(let i = this.students.length - 1; i>=0; i--){
                    if(this.students[i].email === deleteId){
                        this.students.splice(i, 1);
                    }
                }

                if(this.students.length===0) this.hasStudents = false;
            }))
        },
        toggleVisibility: async function(review, reviewedStudent) {
            await AXIOS.post('api/review/update?review_id='+review.review_id,

            {
                review_id: review.review_id,
                rating: review.rating,
                comment: review.comment,
                isVisible: !review.isVisible,
                reviewAuthor:review.reviewAuthor,
                student: {email: reviewedStudent.email}

            }
            ).then((response => {
                console.log("Toggled review");
                window.location.reload(true);
            }))
        }
    }
}
