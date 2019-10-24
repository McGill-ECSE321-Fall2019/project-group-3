package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Course;
import com.ecse321.group3.tutorME.domain.Student;
import com.ecse321.group3.tutorME.repository.StudentRepository;
import com.ecse321.group3.tutorME.service.StudentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceIF {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Student createStudent(Student student) throws Exception {
        Student studentCreated = null;

        try {
            studentCreated = studentRepo.save(student);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return studentCreated;
    }

    @Override
    public Student getStudent(String email) throws Exception {
        Student student = null;

        try {
            student = studentRepo.findById(email).get();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return student;    
        }

    @Override
    public List<Student> getStudents() throws Exception {
        List<Student> students = null;
        try {
            students = studentRepo.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return students;     
        }

    @Override
    public void deleteStudent(String email) throws Exception {
        try {
            studentRepo.deleteById(email);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return; 
    }
    
    @Override
    public Student updateStudent(String oldEmail, Student student) throws Exception {
        //delete the course
        Student studentUpdated = null;
        try {
            studentRepo.deleteById(oldEmail);
            studentUpdated = studentRepo.save(student);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return studentUpdated; 
    }


}