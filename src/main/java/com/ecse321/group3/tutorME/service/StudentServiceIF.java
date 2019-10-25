package com.ecse321.group3.tutorME.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecse321.group3.tutorME.domain.Student;
@Service
public interface StudentServiceIF {
	
	Student createStudent(Student student) throws Exception;
	Student getStudent(String emailAddress) throws Exception;
    List<Student> getStudents() throws Exception;
    Student updateStudent(String oldId, Student student) throws Exception;
    void deleteStudent(String emailAddress) throws Exception;
	
	

}
