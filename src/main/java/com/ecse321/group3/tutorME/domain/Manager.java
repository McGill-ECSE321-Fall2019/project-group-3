package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager extends UserRole {

    public Manager() {
    }

}
