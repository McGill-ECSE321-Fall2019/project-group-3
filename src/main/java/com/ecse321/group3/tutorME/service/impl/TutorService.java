package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserRole;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.TutorServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class TutorService implements TutorServiceIF {

    @Autowired
    private UserRoleRepository tutorRepo;
    
   // public UserRole findByUserEmailAddress(String emailAddress) {
    	
    	UserRole user = null;
    //	user = tutorRepo.findById(id)
   // }
    
    
    
    
    

    @Override
    public Tutor createTutor(Tutor tutor) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
    	Tutor tutorCreated = null;

        //create the tutor, by saving to the database.
        try {
        	tutorCreated = tutorRepo.save(tutor);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the tutor we created.
        return tutorCreated;
    }

    @Override
    public Tutor getTutor(String emailAddress) throws Exception {
        Tutor tutorCreated = null;

        //create the tutor, by saving to the database.
        try {
            tutorCreated = (Tutor) tutorRepo.findByUserEmail(emailAddress);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the tutor we created.
        return tutorCreated;    
        }

    @Override
    public List<Tutor> getTutors() throws Exception {
        List<Tutor> tutors = null;

        //create the tutor, by saving to the database.
        try {
        	List<UserRole> tutor_users = tutorRepo.findAll();
        	for(int i = 0; i < tutor_users.size(); i++) {
        	    if (tutor_users.get(i) instanceof Tutor) {
        	        tutors.add((Tutor) tutor_users.get(i));
                }
        	}
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the tutors we created.
        return tutors;     
        }


   @Override
   public Tutor updateTutor(int oldId, Tutor tutor) throws Exception {
        Tutor tutor_updated = null;
       try {
           tutorRepo.deleteById(oldId);
           tutor_updated = tutorRepo.save(tutor);
       } catch(Exception e){
           //if we get errors getting to database, throw an exception
           throw new Exception(e.getMessage());
       }
       return tutor_updated;
   }








    @Override
    public void deleteTutor(String emailAddress) throws Exception {
        //delete the tutor
        try {
        	tutorRepo.deleteByUserEmail(emailAddress);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return; 
    }


}