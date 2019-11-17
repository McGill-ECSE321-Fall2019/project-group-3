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
