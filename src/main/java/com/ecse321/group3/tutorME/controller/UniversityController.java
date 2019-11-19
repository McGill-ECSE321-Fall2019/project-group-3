package com.ecse321.group3.tutorME.controller;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.service.UniversityServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UniversityController {

    @Autowired
    private UniversityServiceIF universityService;

    
    @RequestMapping(value = "/api/university", method = POST)
    public ResponseEntity<University> createUniversity(@RequestBody University university){
        if(university == null || university.getUniversity_name() == null || university.getUniversity_name().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        University createdUniversity = null;

        try{
            createdUniversity = universityService.createUniversity(university);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(createdUniversity, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university", method = GET)
    public ResponseEntity<University> getUniversity(@RequestParam String universityName){

       
        if(universityName == null || universityName.isEmpty()){
         
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        
        University university = null;

        try{
            university = universityService.getUniversity(universityName);
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(university, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/getall", method = GET)
    public ResponseEntity<List<University>> getUniversities(){
        List<University> universities = null;
        try{
            universities = universityService.getUniversities();
        } catch(Exception e){
           
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(universities, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/update", method = POST)
    public ResponseEntity<University> updateUniversity(@RequestParam String oldId, @RequestBody University university){
        
        if( oldId ==null || university == null || oldId.isEmpty()){
           
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        University universityUpdated = null;

        try{
            universityUpdated = universityService.updateUniversity(oldId, university);
        } catch(Exception e){
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
        return new ResponseEntity<>(universityUpdated, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/university/delete", method = DELETE)
    public ResponseEntity<University> deleteUniversity(@RequestParam String universityName){
    	
        if(universityName == null || universityName.isEmpty()){
            
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
           universityService.deleteUniversity(universityName);
        } catch(Exception e){
     
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
