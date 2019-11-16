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
        form: {
			payroll: [],
		user: {
		  email: '',
		  firstName: '',
		  lastName: '',
		  password: '',
		  verified: true
		}
	},
	status: 'not_accepted'
      }
	},
    methods: {
            register: function(firstname, lastname, email, password) {
				console.log("HALOOOOOOOOOOO");
            if (firstname == '') {
                var errorMsg = "Invalid first name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (lastname == '') {
                var errorMsg = "Invalid last name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (email == '') {
                var errorMsg = "Invalid email"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
            }
            if (password == '') {
                var errorMsg = "Invalid password"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return;
			}
				console.log("working till here");
				let newUser = {}; 
				newUser.email=email;
				newUser.firstName = firstname; 
					newUser.lastName = lastname;
					newUser.password=password;

				this.form.user = newUser; 
					console.dir(this.form);
				AXIOS.post(`/api/manager`,this.data.form)
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data
                    console.log(this.response)
                    this.response = "Account Registered!"
                    this.firstname= ''
                    this.lastname= ''
                    this.email= ''
                    this.password= ''
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

