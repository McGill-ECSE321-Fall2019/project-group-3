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
        Subject subjectCreated = null;

        try {
            subjectCreated = subjectRepo.save(subject);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return subjectCreated;
    }

    @Override
    public Subject getSubject(String subjectName) throws Exception {
        Subject subject = null;

        try{
            subject = subjectRepo.getOne(subjectName);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return subject;
    }

    @Override
    public List<Subject> getSubjects() throws Exception {
        List<Subject> subjects = null;

        try{
            subjects = subjectRepo.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return subjects;
    }

    public Subject updateSubject(String subjectName, Subject subject) throws Exception{
        Subject subjectUpdated = null;

        try {
            deleteSubject(subjectName);
            subjectUpdated = createSubject(subject);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return subjectUpdated;
    }

    @Override
    public void deleteSubject(String subjectName) throws Exception {
        try{
            subjectRepo.deleteById(subjectName);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}