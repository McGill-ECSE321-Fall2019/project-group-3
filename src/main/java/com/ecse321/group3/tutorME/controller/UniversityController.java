package com.ecse321.group3.tutorME.controller;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.service.UniversityServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityServiceIF universityService;

    //request mapping makes this method link to tutorme-heroku.com/api/university
    //the request body just says that take in a university object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/university", method = POST)
    public ResponseEntity<University> createUniversity(@RequestBody University university){

        //validate the input first.
        if(university == null || university.getUniversity_name() == null || university.getUniversity_name().isEmpty()){
            //invalid subject entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the subject service to create the subject.
        University createdUniversity = null;

        try{
            createdUniversity = universityService.createUniversity(university);
        } catch(Exception e){
            //If we get any exceptions while creating a subject, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created subject with a ok status
        return new ResponseEntity<>(createdUniversity, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university", method = GET)
    public ResponseEntity<University> getUniversity(@RequestParam String universityName){

        //validate the input first.
        if(universityName == null || universityName.isEmpty()){
            //invalid lesson name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the lesson service to create the lesson.
        University university = null;

        try{
            university = universityService.getUniversity(universityName);
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(university, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/getall", method = GET)
    public ResponseEntity<List<University>> getUniversities(){
        List<University> universities = null;
        
        //tell the lesson service to list all lessons.
        try{
            universities = universityService.getUniversities();
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/update", method = POST)
    public ResponseEntity<University> updateUniversity(@RequestParam String oldId, @RequestBody University university){
        //validate the input first.
        if( oldId ==null || university == null || oldId.isEmpty()){
            //invalid tutor name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        University universityUpdated = null;

        try{
            universityUpdated = universityService.updateUniversity(oldId, university);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(universityUpdated, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/delete", method = DELETE)
    public ResponseEntity<University> deleteUniversity(@RequestParam String universityName){
    	//validate the input first.
        if(universityName == null || universityName.isEmpty()){
            //invalid lesson id entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
           universityService.deleteUniversity(universityName);
        } catch(Exception e){
            //If we get any exceptions while getting a lesson, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the lesson with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
