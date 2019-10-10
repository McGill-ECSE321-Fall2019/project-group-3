package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue
    private int university_id;

    @ManyToMany
    private List<Subject> subjects;

    public University() {}

    public University(int university_id, List<Subject> subjects) {
        this.university_id = university_id;
        this.subjects = subjects;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
