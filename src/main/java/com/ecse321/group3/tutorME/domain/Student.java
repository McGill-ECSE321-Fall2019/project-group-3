package com.ecse321.group3.tutorME.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;

    @OneToMany(mappedBy = "student")
    private List<Review> review;

    public Student() {
    }

    

    public Student(int student_id, List<Review> review) {
		super();
		this.student_id = student_id;
		this.review = review;
	}



	public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }



	public List<Review> getReview() {
		return review;
	}



	public void setReview(List<Review> review) {
		this.review = review;
	}

	
    
}
