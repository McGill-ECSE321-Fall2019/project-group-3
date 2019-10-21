package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.SubjectRepository;
import com.ecse321.group3.tutorME.service.SubjectServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubjectService implements SubjectServiceIF {

    @Autowired
    private SubjectRepository subjectRepo;

    @Override
    public Subject createSubject(Subject subject) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        Subject subjectCreated = null;

        //create the subject, by saving to the database.
        try {
            subjectCreated = subjectRepo.save(subject);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the subject we created.
        return subjectCreated;
    }

    @Override
    public Subject getSubject(String subjectName) throws Exception {
        return null;
    }

    @Override
    public List<Subject> getSubjects() throws Exception {
        return null;
    }

    @Override
    public void deleteSubject(String subjectName) throws Exception {

    }


}