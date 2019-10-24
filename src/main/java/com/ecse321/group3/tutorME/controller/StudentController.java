package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Student;
import com.ecse321.group3.tutorME.service.StudentServiceIF;
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
public class StudentController {

    @Autowired
    private StudentServiceIF studentService;

    //request mapping makes this method link to tutorme-heroku.com/api/tutor
    //the request body just says that take in a tutor object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/student", method = POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        //validate the input first.
        if(student == null){
            //invalid subject entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the tutor service to create the tutor.
        Student createdStudent = null;

        try{
            createdStudent = studentService.createStudent(student);
        } catch(Exception e){
            //If we get any exceptions while creating a subject, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created subject with a ok status
        return new ResponseEntity<>(createdStudent, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/student", method = GET)
    public ResponseEntity<Student> getStudent(@RequestParam String emailAddress){

        //validate the input first.
        if(emailAddress == null ||emailAddress.isEmpty()){
            //invalid tutor name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the tutor service to create the tutor.
        Student student = null;

        try{
            student = studentService.getStudent(emailAddress);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/student/getall", method = GET)
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = null;
        
        //tell the tutor service to list all tutors.
        try{
            students = studentService.getStudents();
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/student/update", method = POST)
    public ResponseEntity<Student> updateStudent(@RequestParam String oldId, @RequestBody Student student){
        //validate the input first.
        if( oldId ==null || student == null || oldId.isEmpty()){
            //invalid tutor name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Student studentUpdated = null;

        try{
            studentUpdated = studentService.updateStudent(oldId, student);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/student/delete", method = DELETE)
    public ResponseEntity<Student> deleteStudent(@RequestParam String emailAddress){
    	//validate the input first.
        if(emailAddress.isEmpty() ){
            //invalid tutor id entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            studentService.deleteStudent(emailAddress);
        } catch(Exception e){
            //If we get any exceptions while getting a tutor, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the tutor with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}