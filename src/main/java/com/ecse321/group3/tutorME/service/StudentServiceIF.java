package com.ecse321.group3.tutorME.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecse321.group3.tutorME.domain.Student;
@Service
public interface StudentServiceIF {
	
	Student createStudent(Student student) throws Exception;
    List<Student> getStudents() throws Exception;
    //todo: update.
    void deleteStudent(String emailAddress) throws Exception;
	Student getStudent(String emailAddress);
	Student updateStudent(String oldId, Student student);

}
