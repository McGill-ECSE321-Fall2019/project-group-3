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
            rooms: null,
            hasRooms: false
        }
    },
    mounted: function() {
        AXIOS.get('/api/room/getall').then((response => {
            this.rooms = response.data; 
            console.log("made call");
            console.dir(this.rooms); 
            if(this.rooms != null && this.rooms != undefined 
                && this.rooms.length > 0) this.hasRooms = true; 
        }))
    }, 
    methods: {
        deleteRoom: async function(deleteId) {
            await AXIOS.delete('/api/room/delete?roomId='+deleteId).then((response => {
                console.log("i deleted the element!"); 
                
                for(let i = this.rooms.length - 1; i>=0; i--){
                    if(this.rooms[i].room_id === deleteId){
                        this.rooms.splice(i, 1);
                    }
                }

                if(this.rooms.length===0) this.hasRooms = false; 
            }))
        }
    }
}