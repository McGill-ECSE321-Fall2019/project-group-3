package com.ecse321.group3.tutorME.controller;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.service.CourseServiceIF;
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
public class CourseController {

    @Autowired
    private CourseServiceIF courseService;

    //request mapping makes this method link to tutorme-heroku.com/api/course
    //the request body just says that take in a course object (json)
    //the method could be GET instead of POST where appropriate.
    @RequestMapping(value = "/api/course", method = POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course){

        //validate the input first.
        if(course == null || course.getCourseName() == null || course.getCourseName().isEmpty()){
            //invalid course entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the course service to create the subject.
        Course createdCourse = null;

        try{
            createdCourse = courseService.createCourse(course);
        } catch(Exception e){
            //If we get any exceptions while creating a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the created course with a ok status
        return new ResponseEntity<>(createdCourse, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/course", method = GET)
    public ResponseEntity<Course> getCourse(@RequestParam String courseName){

        //validate the input first.
        if(courseName == null || courseName.isEmpty()){
            //invalid course name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        //tell the course service to create the course.
        Course course = null;

        try{
            course = courseService.getCourse(courseName);
        } catch(Exception e){
            //If we get any exceptions while getting a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the course with an ok status
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/course/getall", method = GET)
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courses = null;
        
        //tell the course service to list all courses.
        try{
            courses = courseService.getCourses();
        } catch(Exception e){
            //If we get any exceptions while getting a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the course with an ok status
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/course", method = DELETE)
    public ResponseEntity<Course> deleteCourse(@RequestParam String courseName){
    	//validate the input first.
        if(courseName == null || courseName.isEmpty()){
            //invalid course name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try{
            courseService.deleteCourse(courseName);
        } catch(Exception e){
            //If we get any exceptions while getting a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the course with an ok status
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/course/update", method = POST)
    public ResponseEntity<Course> updateCourse(@RequestParam String oldName, @RequestBody Course course){
    	//validate the input first.
        if(oldName == null || oldName.isEmpty() || course == null || course.getCourseName().isEmpty()){
            //invalid course name entered, return a bad request.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Course courseUpdated = null;

        try{
            courseUpdated = courseService.updateCourse(oldName, course);
        } catch(Exception e){
            //If we get any exceptions while getting a course, we will return a server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //if no errors, we're going to return the course with an ok status
        return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
    }

}
