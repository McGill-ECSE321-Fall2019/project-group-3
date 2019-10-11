package com.ecse321.group3.tutorME.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends UserRole {

    @OneToMany(mappedBy = "student")
    private List<Review> review;

    public Student() {
    }

    

    public Student(List<Review> review) {
		super();
        this.review = review;
	}


    public List<Review> getReview() {
		return review;
	}



	public void setReview(List<Review> review) {
		this.review = review;
	}

	
    
}
