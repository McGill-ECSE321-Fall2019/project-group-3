package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectServiceIF {

    //Creating an interface for all the methods a subject will have.
    Subject createSubject(Subject subject) throws Exception;
    Subject getSubject(String subjectName) throws Exception;
    List<Subject> getSubjects() throws Exception;
    Subject updateSubject(String oldName, Subject subject) throws Exception;
    void deleteSubject(String subjectName) throws Exception;
}
