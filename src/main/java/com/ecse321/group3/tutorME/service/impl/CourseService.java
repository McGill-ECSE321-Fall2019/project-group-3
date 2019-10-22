package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.service.CourseServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseService implements CourseServiceIF {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Course createCourse(Course course) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        Course courseCreated = null;

        //create the course, by saving to the database.
        try {
            courseCreated = courseRepo.save(course);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return courseCreated;
    }

    @Override
    public Course getCourse(String courseName) throws Exception {
        Course courseCreated = null;

        //create the course, by saving to the database.
        try {
            courseCreated = courseRepo.findById(courseName).get();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return courseCreated;    
        }

    @Override
    public List<Course> getCourses() throws Exception {
        List<Course> courses = null;

        //create the course, by saving to the database.
        try {
            courses = courseRepo.findAll();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return courses;     
        }

    @Override
    public void deleteCourse(String courseName) throws Exception {
        //delete the course
        try {
            courseRepo.deleteById(courseName);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return; 
    }

    @Override
    public Course updateCourse(String oldName, String newName) throws Exception {
        //delete the course
        Course courseUpdated = null;
        try {
            Course courseToUpdate = courseRepo.findById(oldName).get();
            courseToUpdate.setCourseName(newName);
            courseUpdated = courseRepo.save(courseToUpdate);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return courseUpdated; 
    }
}