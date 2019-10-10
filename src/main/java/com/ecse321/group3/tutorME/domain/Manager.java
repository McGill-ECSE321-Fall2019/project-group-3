package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager extends UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int managerId;

    public Manager() {
    }

    public Manager(int managerId) {
        this.managerId = managerId;
    }
}
