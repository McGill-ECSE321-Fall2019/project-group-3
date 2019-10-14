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

	@ManyToOne
	private Manager manager;

	@Column
	private double commission;

	public Payroll() {}

	public Payroll(int payrollId, List<Tutor> tutors, Manager manager) {
		this.payrollId = payrollId;
		this.tutors = tutors;
		this.manager = manager;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
}
