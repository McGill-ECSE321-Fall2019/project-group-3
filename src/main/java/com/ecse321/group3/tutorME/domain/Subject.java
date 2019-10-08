package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class Subject {

    private List<Course> courses;

    public Subject() {
    }

    public Subject(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
