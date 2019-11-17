import axios from 'axios';
import config from '../../../config/index';

let frontendUrl = 'http://' + config.dev.host + ":" + config.dev.port;
let backendUrl = 'https://cors-anywhere.herokuapp.com/' + 'http://' +  config.dev.backendHost;

let AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
});


export default {
  
    data() {
      
        return {
			events: [      {
        start: '2019-11-19 10:35:00',
        end: '2019-11-19 11:30:00',
        title: 'Doctor appointment'
      }],
            lessons: null
        }
    },
    mounted: function() {
		var self = this; 
        AXIOS.get('/api/lesson/getall').then((response => {
			this.lessons = response.data; 
				this.lessons.forEach(lesson=>{
          let newevent={};
          var newFormattedStartTime = lesson.startTime.replace(/T/g, " ");
          newevent.start=newFormattedStartTime;
          console.log(lesson.startTime);
          var newFormattedEndTime= lesson.endTime.replace(/T/g, " ");
					newevent.end=newFormattedEndTime;
					newevent.title=lesson.course.courseName+"\n"+"Room:"+lesson.room.room_id;
					self.events.push(newevent);
					console.dir(self.events);
		})
		}));
    }, 
    methods: {
      
		
			
		}
        

		}