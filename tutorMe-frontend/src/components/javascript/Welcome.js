 import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'https://cors-anywhere.herokuapp.com/' + 'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});
 
 export default {
	  name: 'Login',
    data() {
      return {
        managers:null,
        form: {
          email: '',
          password: ''
        }
      }
    },
    mounted: function() {
        AXIOS.get('/api/manager/getall').then((response => {
            this.managers = response.data; 
            console.log("made call");
            console.dir(this.managers); 
            
            }))
    }, 
    methods: {
      checkPassword: function(){
        console.log("called");
        let valid = false; 
            for(let i = this.managers.length - 1; i>=0; i--){
                    if(this.form.email === this.managers[i].email){
                        if (this.form.password === this.managers[i].password){
                          console.log("passwords equal");
                          valid = true; 
                          this.$router.push("Homepage");
                        }
                    }
                }
                if(!valid)
                  alert("Invalid username/password. Please try again/sign up!");
      },
    }
}
