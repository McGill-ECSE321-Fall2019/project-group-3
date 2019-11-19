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
			events: [{
        start: '',
        end: '',
        title: ''
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
          AXIOS.get('/api/lesson/getCourseRoom?lessonId='+lesson.lessonId).then(resp => {
            let respData = resp.data;
            if (respData.course==null && respData.room ==null){
            newevent.title="No Course/Room assigned yet";
            } else if (respData.course != null && respData.room !=null){
            newevent.title=respData.course.courseName+"\n"+"<b>Room:</b>"+respData.room.room_id;
            } else if (respData.course != null && respData.room == null){
            newevent.title=respData.course.couseName+"\n"+"<b>Room:</b> N/A";
            } else if (respData.course == null && respData.room != null){
            newevent.title="<b>Room:</b>"+respData.room.room_id+"\n"+"<b>Course:</b> N/A";
            }
            self.events.push(newevent);
          }).catch(e => function(e){
            console.log(e);
          });
					console.dir(self.events);
		})
		}));
    }, 
    methods: {
      
		
			
		}
        

		}