package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int review_id;

	@Column
	private int rating;

	@Column
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Tutor tutor;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Student student;

	@Enumerated(EnumType.STRING)
	@Column
	private ReviewAuthor reviewAuthor;

	public Review() {}

	

	public Review(int review_id, int rating, String comment, Tutor tutor, Student student, ReviewAuthor reviewAuthor) {
		super();
		this.review_id = review_id;
		this.rating = rating;
		this.comment = comment;
		this.tutor = tutor;
		this.student = student;
		this.reviewAuthor = reviewAuthor;
	}



	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ReviewAuthor getReviewAuthor() {
		return reviewAuthor;
	}

	public void setReviewAuthor(ReviewAuthor reviewAuthor) {
		this.reviewAuthor = reviewAuthor;
	}
	
	
}
