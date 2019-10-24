package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.repository.UniversityRepository;
import com.ecse321.group3.tutorME.service.CourseServiceIF;
import com.ecse321.group3.tutorME.service.UniversityServiceIF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UniversityService implements UniversityServiceIF {

    @Autowired
    private UniversityRepository universityRepo;

    @Override
    public University createUniversity(University university) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        University universityCreated = null;

        //create the course, by saving to the database.
        try {
            universityCreated = universityRepo.save(university);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return universityCreated;
    }

    @Override
    public University getUniversity(String universityName) throws Exception {
        University universityCreated = null;

        //create the course, by saving to the database.
        try {
            universityCreated = universityRepo.findById(universityName).get();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return universityCreated;    
        }

    @Override
    public List<University> getUniversities() throws Exception {
        List<University> universities = null;

        //create the course, by saving to the database.
        try {
            universities = universityRepo.findAll();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the course we created.
        return universities;     
        }

    @Override
    public void deleteUniversity(String universityName) throws Exception {
        //delete the course
        try {
            universityRepo.deleteById(universityName);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return; 
    }

    @Override
    public University updateUniversity(String oldName, University university) throws Exception {
        //delete the course
        University universityUpdated = null;
        try {
            universityRepo.deleteById(oldName);
            universityUpdated = universityRepo.save(university);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return universityUpdated; 
    }
}