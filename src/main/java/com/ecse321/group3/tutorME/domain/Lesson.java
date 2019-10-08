package com.ecse321.group3.tutorME.domain;

public class Lesson {

    private Course course;

    public Lesson() {}

    public Lesson(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
