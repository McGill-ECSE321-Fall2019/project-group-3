package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
public class Student extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;

    @OneToMany
    private Review review; 

    public Student() {
    }

    public Student(int studentId) {
        this.student_id = studentId;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
