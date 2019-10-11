package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column
    private String subject_name;

    @ManyToMany(mappedBy = "subjects")
    private List<University> universities;

    @OneToMany(mappedBy = "subject")
    private List<Course> courses;

    public Subject() {
    }

    public Subject(String subjectName, List<University> universities, List<Course> courses) {
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
