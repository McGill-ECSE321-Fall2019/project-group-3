    
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
        size_options: [
          { value: null, text: 'Please select an option' },
          { value: 'BIG', text: 'BIG' },
          { value: 'SMALL', text: 'SMALL' }
        ],
		  form: {
        roomId: "1",
				numberOfSeats: "1",
        lesson: null,
        course: null,
        size: null,
        roomAvailability: null
            }, 
      }
    },
    mounted: async function getAllData() {
        this.checkIfForUpdate();
        var self = this;
        self.map = new Map(); 
    },
    methods: {
      async onSubmit(evt) {
        evt.preventDefault();
        let self = this;
        console.dir(self.form);
        await AXIOS.post('/api/room', self.form).then(resp => {
                alert("Room created! Redirecting");
                this.$router.push("Room");
            }).catch(e => {
                console.log("error: " + e);
            });
      },
      checkIfForUpdate: async function () {
            if(this.$route.query.update!=null && this.$route.query.update!=undefined){
                //this component is for updating, preload data. 
                console.log("Create Room is for Update Room :O")
                let roomId = this.$route.query.update; 
                await AXIOS.get('/api/room?roomId='+roomId).then(resp => {
                    let respData = resp.data; 
                    this.form = respData;
                    this.update = true;
                    this.$forceUpdate();
                }).catch(e => function(e){
                    console.log(e);
                });
            }
        }
    }
}