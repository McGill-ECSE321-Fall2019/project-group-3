package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Room;
import com.ecse321.group3.tutorME.service.RoomServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class RoomController {

    @Autowired
    private RoomServiceIF roomService;

    //request mapping makes this method link to tutorme-heroku.com/api/lesson
    //the request body just says that take in a lesson object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/room", method = POST)
    public ResponseEntity<Room> createLesson(@RequestBody Room room){

        //validate the input first.
        if(room == null || room.getRoom_id() < 0){
            //invalid subject entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the lesson service to create the lesson.
        Room createdRoom = null;

        try{
        	createdRoom = roomService.createRoom(room);
        } catch(Exception e){
            //If we get any exceptions while creating a subject, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created subject with a ok status
        return new ResponseEntity<>(createdRoom, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/room", method = GET)
    public ResponseEntity<Room> getRoom(@RequestParam int roomId){

        //validate the input first.
        if(roomId < 0){
            //invalid lesson name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the lesson service to create the lesson.
        Room room = null;

        try{
            room = roomService.getRoom(roomId);
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/room/getall", method = GET)
    public ResponseEntity<List<Room>> getRooms(){
        List<Room> rooms = null;
        
        //tell the lesson service to list all lessons.
        try{
            rooms = roomService.getRooms();
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/room/delete", method = DELETE)
    public ResponseEntity<Room> deleteRoom(@RequestParam int roomId){
    	//validate the input first.
        if(roomId < 0 ){
            //invalid lesson id entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            roomService.deleteRoom(roomId);
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}