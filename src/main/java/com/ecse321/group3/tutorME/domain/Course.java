package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    private int courseNumber;

    @OneToOne
    private Subject subject;

    @OneToMany
    private List<Lesson> lessons;

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
}
