package com.ecse321.group3.tutorME.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column
    private String subject_name;

    @ManyToOne
    @JsonBackReference(value = "university-subject")
    private University universities;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "subject-course")
    private List<Course> courses;

    public Subject() {
    }

    public Subject(String subjectName, University universities, List<Course> courses) {
        this.subject_name = subjectName;
        this.universities = universities;
        this.courses = courses;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public University getUniversities() {
        return universities;
    }

    public void setUniversities(University universities) {
        this.universities = universities;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
