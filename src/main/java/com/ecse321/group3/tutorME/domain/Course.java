package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column
    private int courseNumber;

    @ManyToOne
    private Subject subject;

    @OneToMany
    private List<Lesson> lessons;

    @ManyToMany
    private List<Tutor> tutors;

    public Course() {
    }

    public Course(Subject subject, List<Lesson> lessons, int courseNumber) {
        this.subject = subject;
        this.lessons = lessons;
        this.courseNumber = courseNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }
}
