package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {

    @Id
    @Column
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private List<University> universities;

    @OneToMany(mappedBy = "subject")
    private List<Course> courses;

    public Subject() {
    }

    public Subject(String subjectName, List<University> universities, List<Course> courses) {
        this.subjectName = subjectName;
        this.universities = universities;
        this.courses = courses;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
