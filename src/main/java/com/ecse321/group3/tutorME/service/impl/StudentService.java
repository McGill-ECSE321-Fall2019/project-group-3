package com.ecse321.group3.tutorME.service.impl;
import com.ecse321.group3.tutorME.domain.Student;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import com.ecse321.group3.tutorME.service.StudentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceIF {

	@Autowired
    private UserEntityRepository studentRepo;

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

        try{
            student = (Student) studentRepo.getOne(email);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return student;
    }

    @Override
    public List<Student> getStudents() throws Exception {
        List<Student> students = null;

        try{
            students = studentRepo.findAll().stream()
                    .filter(x -> x instanceof Student)
                    .map(x -> (Student) x)
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return students;
    }

    @Override
    public Student updateStudent(String oldEmail, Student student) throws Exception {
        Student updatedStudent = null;

        try{
            deleteStudent(oldEmail);
            updatedStudent = createStudent(student);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return updatedStudent;
    }

    @Override
    public void deleteStudent(String email) throws Exception {
        Student studentToDelete = this.getStudent(email);
        try{
            studentRepo.deleteById(studentToDelete.getEmail());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
