package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Payroll;
import com.ecse321.group3.tutorME.service.PayrollServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "*")
public class PayrollController {

    @Autowired
    private PayrollServiceIF payrollService;

    //request mapping makes this method link to tutorme-heroku.com/api/payroll
    //the request body just says that take in a payroll object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/payroll", method = POST)
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll){

        //validate the input first.
        if(payroll == null || payroll.getPayrollId() <=0){
            //invalid payroll entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the payroll service to create the payroll.
       Payroll createdPayroll= null;

        try{
            createdPayroll = payrollService.createPayroll(payroll);
        } catch(Exception e){
            //If we get any exceptions while creating a payroll, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created payroll with a ok status
        return new ResponseEntity<>(createdPayroll, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/payroll", method = GET)
    public ResponseEntity<Payroll> getPayroll(@RequestParam int id){

        //validate the input first.
        if(id <= 0){
            //invalid payroll name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the payroll service to create the payroll.
        Payroll payroll = null;

        try{
            payroll = payrollService.getPayroll(id);
        } catch(Exception e){
            //If we get any exceptions while getting a payroll, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the payroll with an ok status
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/payroll/getall", method = GET)
    public ResponseEntity<List<Payroll>> getPayrolls(){
        List<Payroll> payrolls = null;
        
        //tell the payroll service to list all payrolls.
        try{
            payrolls = payrollService.getPayrolls();
        } catch(Exception e){
            //If we get any exceptions while getting a payroll, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the payroll with an ok status
        return new ResponseEntity<>(payrolls, HttpStatus.OK);
    }
    @RequestMapping(value = "/api/payroll/update", method = POST)
    public ResponseEntity<Payroll> updatePayroll(@RequestParam int oldId, @RequestBody Payroll payroll){
        //validate the input first.
        if( oldId <= 0 || payroll == null){
            //invalid payroll name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Payroll payroll_updated = null;

        try{
            payroll_updated = payrollService.updatePayroll(oldId, payroll);
        } catch(Exception e){
            //If we get any exceptions while getting a payroll, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the payroll with an ok status
        return new ResponseEntity<>(payroll_updated, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/api/payroll/delete", method = DELETE)
    public ResponseEntity<Payroll> deletePayroll(@RequestParam int id){
    	//validate the input first.
        if(id <= 0  ){
            //invalid payroll id entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            payrollService.deletePayroll(id);
        } catch(Exception e){
            //If we get any exceptions while getting a payroll, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the payroll with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
