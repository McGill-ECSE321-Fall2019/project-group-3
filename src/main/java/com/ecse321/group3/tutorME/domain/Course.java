package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class Course {

    private Subject subject;
    private List<Lesson> lessons;

    public Course() {
    }

    public Course(Subject subject, List<Lesson> lessons) {
        this.subject = subject;
        this.lessons = lessons;
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
}
