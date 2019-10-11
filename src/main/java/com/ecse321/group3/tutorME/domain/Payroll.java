package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payrollId;

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
