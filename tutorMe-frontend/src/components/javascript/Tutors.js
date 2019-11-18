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
            review_scores:[],
            hasTutors: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/tutor/getall').then((response => {
            this.tutors = response.data;
            console.log("made call");
            console.dir(this.tutors);
            if(this.tutors != null && this.tutors != undefined
                && this.tutors.length > 0) {
                this.hasTutors = true;
            for(let i = 0; i < this.tutors.length; i++){
                let average = 0;
                for(let j = 0; j < this.tutors[i].reviews.length; j++){
                    average += this.tutors[i].reviews[j].rating;
                }
                console.log("avg" + average);
                average /= this.tutors[i].reviews.length;
                this.review_scores[i] = (average);
                console.log(review_scores);
            }
        }
    }))

    },
    methods: {
        getReviewScore: function(reviewIndex) {
            return this.review_scores[reviewIndex];
        },
        deleteTutor: async function(deleteId) {
            await AXIOS.delete('/api/tutor/delete?emailAddress='+deleteId).then((response => {
                console.log("i deleted the element!");

                for(let i = this.tutors.length - 1; i>=0; i--){
                    if(this.tutors[i].email === deleteId){
                        this.tutors.splice(i, 1);
                    }
                }

                if(this.tutors.length===0) this.hasTutors = false;
            }))
        },
        rejectCourse: async function(tutor, applied_course) {
            for(let i = tutor.courses_applied.length - 1; i>=0; i--){
                tutor.courses_applied[i].tutors = null;
                if(tutor.courses_applied[i].courseName === applied_course.courseName){
                    tutor.courses_applied.splice(i, 1);
                }
            }
            for(let i = tutor.courses_taught.length - 1; i>=0; i--){
                tutor.courses_taught[i].tutors = null;

            }
            await AXIOS.post('api/tutor/update?oldId='+tutor.email,
            {
                email: tutor.email,
                firstName: tutor.firstName,
                lastName: tutor.lastName,
                password: tutor.password,
                rate: tutor.rate,
                courses_taught: tutor.courses_taught,
                courses_applied : tutor.courses_applied,
                reviews: tutor.reviews,
                schedule: tutor.schedule,
                lesson: tutor.lesson,
                verified: tutor.verified

            }
            ).then((response => {
                console.log("Rejected tutor");
            }))
        },
        approveCourse: async function(tutor, applied_course) {
            for(let i = tutor.courses_applied.length - 1; i>=0; i--){
                tutor.courses_applied[i].tutors = null;
                if(tutor.courses_applied[i].courseName === applied_course.courseName){
                    tutor.courses_applied.splice(i, 1);
                }
            }
            for(let i = tutor.courses_taught.length - 1; i>=0; i--){
                tutor.courses_taught[i].tutors = null;

            }
            tutor.courses_taught.push(applied_course);
            await AXIOS.post('api/tutor/update?oldId='+tutor.email,
            {
                email: tutor.email,
                firstName: tutor.firstName,
                lastName: tutor.lastName,
                password: tutor.password,
                rate: tutor.rate,
                courses_taught: tutor.courses_taught,
                courses_applied : tutor.courses_applied,
                reviews: tutor.reviews,
                schedule: tutor.schedule,
                lesson: tutor.lesson,
                verified: tutor.verified

            }
            ).then((response => {
                console.log("Approved tutor");
            }))
        },
        toggleVisibility: async function(review, reviewedTutor) {
            await AXIOS.post('api/review/update?review_id='+review.review_id, 
            {
                review_id: review.review_id,
                rating: review.rating,
                comment: review.comment,
                isVisible: !review.isVisible,
                reviewAuthor:review.reviewAuthor,
                tutor: {email: reviewedTutor.email}

            }
            ).then((response => {
                console.log("Toggled review");
                window.location.reload(true);
            }))
        }
    }
}
