package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class University {

    private List<Subject> subjects;

    public University() {}

    public University(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
