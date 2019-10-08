package com.ecse321.group3.tutorME.domain;

import java.util.List;

public class Payroll {
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
