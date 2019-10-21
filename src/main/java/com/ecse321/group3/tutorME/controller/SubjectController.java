package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.service.SubjectServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class SubjectController {

    @Autowired
    private SubjectServiceIF subjectService;

    //request mapping makes this method link to tutorme-heroku.com/api/subject
    //the request body just says that take in a subject object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/subject", method = POST)
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){

        //validate the input first.
        if(subject == null || subject.getSubject_name() == null || subject.getSubject_name().isEmpty()){
            //invalid subject entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the subject service to create the subject.
        Subject createdSubject = null;

        try{
            createdSubject = subjectService.createSubject(subject);
        } catch(Exception e){
            //If we get any exceptions while creating a subject, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created subject with a ok status
        return new ResponseEntity<>(createdSubject, HttpStatus.OK);
    }

}
