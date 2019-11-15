package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Manager;
import com.ecse321.group3.tutorME.service.ManagerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin("*")
public class ManagerController {

    @Autowired
    private ManagerServiceIF managerService;

    @RequestMapping(value = "/api/manager", method = POST)
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager){

        if(manager == null || manager.getUser() == null || manager.getUser().getEmail().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Manager createdManager = null;

        try{
            createdManager = managerService.createManager(manager);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdManager, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/manager", method = GET)
    public ResponseEntity<Manager> getManager(@RequestParam String email){

        if(email == null || email.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Manager manager = null;

        try{
            manager = managerService.getManager(email);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/manager/getall", method = GET)
    public ResponseEntity<List<Manager>> getManagers(){
        List<Manager> managers = null;

        try{
            managers = managerService.getManagers();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/manager/update", method = POST)
    public ResponseEntity<Manager> updateManager(@RequestParam String oldEmail, @RequestBody Manager manager){

        if(oldEmail == null || oldEmail.isEmpty() || manager == null || manager.getUser() == null
                || manager.getUser().getEmail().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Manager updatedSub = null;

        try{
            updatedSub = managerService.updateManager(oldEmail, manager);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updatedSub, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/manager", method = DELETE)
    public ResponseEntity<Manager> deleteManager(@RequestParam String email){

        if(email == null || email.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            managerService.deleteManager(email);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
