package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserRole;
import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.TutorServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            tutors = tutorRepo.findAll().stream()
                    .filter(x -> x instanceof Tutor)
                    .map(x -> (Tutor) x)
                    .collect(Collectors.toList());
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the tutors we created.
        return tutors;     
        }


   @Override
   public Tutor updateTutor(String oldId, Tutor tutor) throws Exception {
        Tutor tutor_updated = null;
       try {
           deleteTutor(oldId);
           tutor_updated = createTutor(tutor);
       } catch(Exception e){
           //if we get errors getting to database, throw an exception
           throw new Exception(e.getMessage());
       }
       return tutor_updated;
   }



    @Override
    public void deleteTutor(String emailAddress) throws Exception {
        //delete the tutor
        Tutor tutorToBeDeleted = getTutor(emailAddress);
        try {
        	tutorRepo.deleteById(tutorToBeDeleted.getUserId());
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
    }
}