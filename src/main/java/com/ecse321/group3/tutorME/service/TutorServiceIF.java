package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserEntity;
import com.ecse321.group3.tutorME.domain.UserRole;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TutorServiceIF {

    //Creating an interface for all the methods a subject will have.
    Tutor createTutor(Tutor tutor) throws Exception;
    Tutor getTutor(String emailAddress) throws Exception;
    List<Tutor> getTutors() throws Exception;
    Tutor updateTutor(int oldId, Tutor tutor) throws Exception;
    void deleteTutor(String emailAddress) throws Exception;
}






//Lessons:
//Create lesson - done
//Get lesson by id - done
//Get a list of all lessons - done
//Update lesson start time
//Update lesson end time
//Delete lesson (only if start time is later than today)

//Tutors: 
//Create Tutor - done
//Get tutor by id - done
//Get a list of all the tutors - done
//Update a tutor’s information
//Delete a tutor - done
