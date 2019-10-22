package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseServiceIF {

    //Creating an interface for all the methods a subject will have.
    Course createCourse(Course course) throws Exception;
    Course getCourse(String courseName) throws Exception;
    List<Course> getCourses() throws Exception;
    //todo: update.
    Course updateCourse(String oldName, String newName) throws Exception;
    void deleteCourse(String courseName) throws Exception;
}
