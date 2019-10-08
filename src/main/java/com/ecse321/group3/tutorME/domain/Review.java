package com.ecse321.group3.tutorME.domain;

public class Review {
	private int rating;
	private String comment;
	public Review() {}
	public Review(int rating, String comment) {
		super();
		this.rating = rating;
		this.comment = comment;
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
