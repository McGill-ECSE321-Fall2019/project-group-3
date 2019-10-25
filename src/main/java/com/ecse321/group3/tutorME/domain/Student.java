package com.ecse321.group3.tutorME.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends UserRole {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Review> review;

    @ManyToMany(mappedBy = "student")
    private List<Lesson> lesson;

    public Student() {
    }

    public Student(List<Review> review, List<Lesson> lesson) {
		super();
        this.review = review;
        this.lesson = lesson;
	}


    public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }
}
