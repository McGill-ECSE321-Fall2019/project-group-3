package com.ecse321.group3.tutorME.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column
    private String courseName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "subject-course")
    private Subject subject;

    @OneToMany
    @JsonManagedReference(value = "course-lesson")
    private List<Lesson> lessons;

    @ManyToMany(mappedBy = "courses_taught")
    @JsonIgnoreProperties(value = "courses_taught")
    private List<Tutor> tutors;

    public Course() {
    }

    
    public Course(String courseName, Subject subject, List<Lesson> lessons, List<Tutor> tutors) {
		super();
		this.courseName = courseName;
		this.subject = subject;
		this.lessons = lessons;
		this.tutors = tutors;
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

    
    public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }
}
