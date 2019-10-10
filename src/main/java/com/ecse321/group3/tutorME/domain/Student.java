package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    public Student() {
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
