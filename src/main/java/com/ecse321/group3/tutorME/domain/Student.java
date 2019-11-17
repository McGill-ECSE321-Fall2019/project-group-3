package com.ecse321.group3.tutorME.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student extends UserEntity {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference(value="student-review")
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
