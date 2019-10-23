package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.service.SubjectServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class SubjectController {

    @Autowired
    private SubjectServiceIF subjectService;

    @RequestMapping(value = "/api/subject", method = POST)
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){

        if(subject == null || subject.getSubject_name() == null || subject.getSubject_name().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Subject createdSubject = null;

        try{
            createdSubject = subjectService.createSubject(subject);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdSubject, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/subject", method = GET)
    public ResponseEntity<Subject> getSubject(@RequestParam String subjectName){

        if(subjectName == null || subjectName.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Subject subject = null;

        try{
            subject = subjectService.getSubject(subjectName);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/subject/getall", method = GET)
    public ResponseEntity<List<Subject>> getSubjects(){
        List<Subject> subjects = null;

        try{
            subjects = subjectService.getSubjects();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/subject/update", method = POST)
    public ResponseEntity<Subject> updateSubject(@RequestParam String oldName, @RequestBody Subject subject){

        if(oldName == null || oldName.isEmpty() || subject == null || subject.getSubject_name().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Subject updatedSub = null;

        try{
            updatedSub = subjectService.updateSubject(oldName, subject);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedSub, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/subject", method = DELETE)
    public ResponseEntity<Subject> deleteSubject(@RequestParam String subjectName){

        if(subjectName == null || subjectName.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            subjectService.deleteSubject(subjectName);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
