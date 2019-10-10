package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Payroll {

	@OneToMany
	private List<Tutor> tutors;

	public Payroll() {}

	public Payroll(List<Tutor> tutors) {
		super();
		this.tutors = tutors;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}
	
	
	
	
}
