package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Schedule;
import com.ecse321.group3.tutorME.service.ScheduleServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@CrossOrigin("*")
public class ScheduleController {

	
    @Autowired
    private ScheduleServiceIF scheduleService;

    @RequestMapping(value = "/api/schedule", method = POST)
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule){
        if(schedule == null || schedule.getSchedule_id() <= 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Schedule scheduleCreated = null;
        try{
            scheduleCreated = scheduleService.createSchedule(schedule);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(scheduleCreated, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/schedule", method = GET)
    public ResponseEntity<Schedule> getSchedule(@RequestParam int id){
        if(id <= 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Schedule schedule = null;

        try{
            schedule = scheduleService.getSchedule(id);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/schedule/getall", method = GET)
    public ResponseEntity<List<Schedule>> getUserEntities(){
        List<Schedule> schedules = null;
        try{
            schedules = scheduleService.getSchedules();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/schedule", method = DELETE)
    public ResponseEntity<Schedule> deleteSchedule(@RequestParam int id){
        if(id <= 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
        	scheduleService.deleteSchedule(id);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/schedule/update", method = POST)
    public ResponseEntity<Schedule> updateCourse(@RequestParam int id, @RequestBody Schedule schedule){
        if(id <= 0 || schedule.getSchedule_id() <= 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Schedule scheduleUpdated = null;

        try{
            scheduleUpdated = scheduleService.updateSchedule(id, schedule);
        } catch(Exception e){
            //If we get any exceptions while getting a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the course with an ok status
        return new ResponseEntity<>(scheduleUpdated, HttpStatus.OK);
    }

    
}
