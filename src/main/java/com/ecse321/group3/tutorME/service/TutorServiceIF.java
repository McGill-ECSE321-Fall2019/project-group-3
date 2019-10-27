package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserEntity;
import com.ecse321.group3.tutorME.domain.UserRole;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface TutorServiceIF {

    //Creating an interface for all the methods a tutor will have.
    Tutor createTutor(Tutor tutor) throws Exception;
    Tutor getTutor(String emailAddress) throws Exception;
    List<Tutor> getTutors() throws Exception;
    Tutor updateTutor(String oldId, Tutor tutor) throws Exception;
    void deleteTutor(String emailAddress) throws Exception;
}






