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
                course: null,
                endTime: "",
                room: null,
                startTime: "",
                student: null,
                tutor: null   
            }
        }
    },
    methods: {
        onSubmit(evt) {
            evt.preventDefault()
            console.dir(this.form);
        }, 
        printDate(){
            console.dir(this.form);
        }
    }
}