package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.service.TutorServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@CrossOrigin(origins = "*")
public class TutorController {

    @Autowired
    private TutorServiceIF tutorService;

    //request mapping makes this method link to tutorme-heroku.com/api/tutor
    //the request body just says that take in a tutor object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/tutor", method = POST)
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor){

        //validate the input first.
        if(tutor == null){
            //invalid tutor entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the tutor service to create the tutor.
        Tutor createdTutor = null;

        try{
            createdTutor = tutorService.createTutor(tutor);
        } catch(Exception e){
            //If we get any exceptions while creating a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created tutor with a ok status
        return new ResponseEntity<>(createdTutor, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/tutor", method = GET)
    public ResponseEntity<Tutor> getTutor(@RequestParam String emailAddress){

        //validate the input first.
        if(emailAddress == null ||emailAddress.isEmpty()){
            //invalid tutor name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the tutor service to create the tutor.
        Tutor tutor = null;

        try{
            tutor = tutorService.getTutor(emailAddress);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(tutor, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/tutor/getall", method = GET)
    public ResponseEntity<List<Tutor>> getTutors(){
        List<Tutor> tutors = null;
        
        //tell the tutor service to list all tutors.
        try{
            tutors = tutorService.getTutors();
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/tutor/update", method = POST)
    public ResponseEntity<Tutor> updateTutor(@RequestParam String oldId, @RequestBody Tutor tutor){
        //validate the input first.
        if( oldId == null || oldId.isEmpty() || tutor == null){
            //invalid tutor name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Tutor tutorUpdated = null;

        try{
            tutorUpdated = tutorService.updateTutor(oldId, tutor);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(tutorUpdated, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/tutor/delete", method = DELETE)
    public ResponseEntity<Tutor> deleteTutor(@RequestParam String emailAddress){
    	//validate the input first.
        if(emailAddress.isEmpty() ){
            //invalid tutor id entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            tutorService.deleteTutor(emailAddress);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
