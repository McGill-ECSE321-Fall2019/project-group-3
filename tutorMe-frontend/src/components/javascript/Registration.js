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
        managers:null,
        hasManagers:false,
		form: {
		  email: '',
		  firstName: '',
		  lastName: '',
		  password: '',
          verified: true,
          payroll: []
	},
	status: 'not_accepted'
      }
    },
    mounted: function() {
        AXIOS.get('/api/manager/getall').then((response => {
            this.managers = response.data; 
            console.log("made call");
            console.dir(this.managers); 
            if(this.managers != null && this.managers != undefined 
                && this.managers.length > 0) this.hasManagers = true; 
            }))
    }, 
    methods: {
            register: function() {
                let valid=true;
				console.log("HALOOOOOOOOOOO");
            if (this.form.firstName == '') {
                var errorMsg = "Invalid first name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (this.form.lastName == '') {
                var errorMsg = "Invalid last name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (this.form.email == '') {
                var errorMsg = "Invalid email"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (this.form.password == '') {
                var errorMsg = "Invalid password"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (this.managers != null){
            for(let i = this.managers.length - 1; i>=0; i--){
                    if(this.form.email === this.managers[i].email){
                       alert("This email is already taken. Please use another/sign in!");
                       valid=false;
                    }
                }
            }
            if (valid != false){
			console.log("working till here"); 
			console.dir(this.form);
				AXIOS.post(`/api/manager`,this.form)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data
                    console.log(this.response)
                    this.response = "Account Registered!"
                    this.$router.push("/");
				})
                .catch(e => {
					alert("didnt work");
                    var errorMsg = e.message
                    console.log(errorMsg)
                    this.errorRegister = errorMsg
                    this.response = ''
                });
            }
			}
		}
	}

