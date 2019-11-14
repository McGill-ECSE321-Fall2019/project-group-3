import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'https://cors-anywhere.herokuapp.com/' + 'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});
export default {
	name: 'register',
    data() {
      return {
        form: {
          email: '',
		  password: '',
		  firstname: '',
		  lastname: '',
		  confirmpassword: '',
		  status: 'not_accepted'
        }
      }
	},
	created: function (){
	},
    methods: {
            register(firstname, lastname, email, password) {
            if (firstname == '') {
                var errorMsg = "Invalid first name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return
            }
            if (lastname == '') {
                var errorMsg = "Invalid last name"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return
            }
            if (email == '') {
                var errorMsg = "Invalid email"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return
            }
            if (password == '') {
                var errorMsg = "Invalid password"
                console.log(errorMsg)
                this.errorRegister = errorMsg
                return
            }
     
				AXIOS.post(`/createManager/` + email + "?lastName=" + lastName + "&firstName=" + firstName + "&password=" + password, {}, {})
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.response = response.data
                    console.log(this.response)
                    this.response = "Account Registered!"
                    this.firstname= ''
                    this.lastname= ''
                    this.email= ''
                    this.password= ''
					alert("hello");
				})
                .catch(e => {
					alert("didnt work");
                    var errorMsg = e.message
                    console.log(errorMsg)
                    this.errorRegister = errorMsg
                    this.response = ''
				});
				alert("hello")
			}
		}
	}
