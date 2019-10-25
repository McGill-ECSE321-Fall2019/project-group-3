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
    @RequestMapping(value = "/api/student", method = POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        if(student == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Student createdStudent = null;

        try{
            createdStudent = studentService.createStudent(student);
        } catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      
        return new ResponseEntity<>(createdStudent, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/student", method = GET)
    public ResponseEntity<Student> getStudent(@RequestParam String emailAddress){
        if(emailAddress == null ||emailAddress.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Student student = null;

        try{
            student = studentService.getStudent(emailAddress);
        } catch(Exception e){
   
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/student/getall", method = GET)
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = null;

        try{
            students = studentService.getStudents();
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/student/update", method = POST)
    public ResponseEntity<Student> updateStudent(@RequestParam String oldId, @RequestBody Student student){
        if( oldId ==null || student == null || oldId.isEmpty()){
            
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Student studentUpdated = null;

        try{
            studentUpdated = studentService.updateStudent(oldId, student);
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/student/delete", method = DELETE)
    public ResponseEntity<Student> deleteStudent(@RequestParam String emailAddress){
    	
        if(emailAddress.isEmpty() ){
            
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            studentService.deleteStudent(emailAddress);
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}