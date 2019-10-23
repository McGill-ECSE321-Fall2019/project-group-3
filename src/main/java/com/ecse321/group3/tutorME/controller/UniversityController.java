package com.ecse321.group3.tutorME.controller;


import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.service.UniversityServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

}
