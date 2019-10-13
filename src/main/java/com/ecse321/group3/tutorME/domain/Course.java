package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column
    private String courseName;

    @ManyToOne
    private Subject subject;

    @OneToMany
    private List<Lesson> lessons;

    @ManyToMany
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
