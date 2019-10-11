package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int managerId;

    public Manager() {
    }

    public Manager(int managerId) {
        this.managerId = managerId;
    }

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
