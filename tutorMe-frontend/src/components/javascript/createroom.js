    
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
        size_options: [
          { value: null, text: 'Please select an option' },
          { value: 'BIG', text: 'BIG' },
		  { value: 'SMALL', text: 'SMALL' }],
		  form: {
        roomId: "1",
				numberOfSeats: "1",
        lesson: null,
        course: null,
        roomSize: null,
        roomAvailability: null
            },
            
        
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault();
        let self = this;
        AXIOS.post('/api/room', self.form).then(resp => {
                alert("Room created! Redirecting");
                this.$router.push("Room");
            }).catch(e => {
                console.log("error: " + e);
            });
      }
    }
  }