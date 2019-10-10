package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private int review_id;

	private int rating;
	private String comment;

	public Review() {}

	public Review(int review_id, int rating, String comment) {
		super();
		this.review_id = review_id;
		this.rating = rating;
		this.comment = comment;
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
	
	
}
