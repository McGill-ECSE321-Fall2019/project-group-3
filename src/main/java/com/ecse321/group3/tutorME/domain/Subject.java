package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class Subject {

    private List<University> universities;
    private List<Course> courses;

    public Subject() {
    }

    public Subject(List<University> universities, List<Course> courses) {
        this.universities = universities;
        this.courses = courses;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
