package com.ecse321.group3.tutorME.service.impl;


import com.ecse321.group3.tutorME.domain.University;

import com.ecse321.group3.tutorME.repository.UniversityRepository;

import com.ecse321.group3.tutorME.service.UniversityServiceIF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements UniversityServiceIF {

    @Autowired
    private UniversityRepository universityRepo;

    @Override
    public University createUniversity(University university) throws Exception {
      
        University universityCreated = null;
        try {
            universityCreated = universityRepo.save(university);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return universityCreated;
    }

    @Override
    public University getUniversity(String universityName) throws Exception {
        University universityCreated = null;

        try {
            universityCreated = universityRepo.findById(universityName).get();
        } catch(Exception e){
            
            throw new Exception(e.getMessage());
        }

        return universityCreated;    
        }

    @Override
    public List<University> getUniversities() throws Exception {
        List<University> universities = null;

        try {
            universities = universityRepo.findAll();
        } catch(Exception e){

            throw new Exception(e.getMessage());
        }
        return universities;     
        }

    @Override
    public void deleteUniversity(String universityName) throws Exception {
        try {
            universityRepo.deleteById(universityName);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return; 
    }

    @Override
    public University updateUniversity(String oldName, University university) throws Exception {
        if(university!=null && university.getUniversity_name()!=null && !university.getUniversity_name().isEmpty()
                && !university.getUniversity_name().equals(oldName)){
            university = universityRepo.getOne(oldName);
            university.setUniversity_name(university.getUniversity_name());
        }
        University universityUpdated = null;
        try {
            universityRepo.deleteById(oldName);
            universityUpdated = universityRepo.save(university);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return universityUpdated; 
    }
}