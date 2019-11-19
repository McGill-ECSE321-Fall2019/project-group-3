package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Room;
import com.ecse321.group3.tutorME.service.RoomServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@CrossOrigin("*")
public class RoomController {

    @Autowired
    private RoomServiceIF roomService;

    @RequestMapping(value = "/api/room", method = POST)
    public ResponseEntity<Room> createRoom(@RequestBody Room room){

     
        if(room == null || room.getRoom_id() < 0){
           
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Room createdRoom = null;

        try{
        	createdRoom = roomService.createRoom(room);
        } catch(Exception e){
           
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        return new ResponseEntity<>(createdRoom, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/room", method = GET)
    public ResponseEntity<Room> getRoom(@RequestParam int roomId){

       
        if(roomId < 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Room room = null;

        try{
            room = roomService.getRoom(roomId);
        } catch(Exception e){
           
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
   
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/room/getall", method = GET)
    public ResponseEntity<List<Room>> getRooms(){
        List<Room> rooms = null;
        try{
            rooms = roomService.getRooms();
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/room/update", method = POST)
    public ResponseEntity<Room> updateRoom(@RequestParam int oldId, @RequestBody Room room){
        
        if( oldId <0 || room == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Room roomUpdated = null;

        try{
            roomUpdated = roomService.updateRoom(oldId, room);
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        return new ResponseEntity<>(roomUpdated, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/room/delete", method = DELETE)
    public ResponseEntity<Room> deleteRoom(@RequestParam int roomId){
    	
        if(roomId < 0 ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            roomService.deleteRoom(roomId);
        } catch(Exception e){
           
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}