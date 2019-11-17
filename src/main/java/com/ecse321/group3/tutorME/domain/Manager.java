package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name="manager")
public class Manager extends UserEntity {

    public Manager() {
    }

    public Manager(List<Payroll> payroll) {
        this.payroll = payroll;
    }

    @OneToMany(mappedBy = "manager")
    @JsonManagedReference(value = "manager-payroll")
    private List<Payroll> payroll;

    public List<Payroll> getPayroll() {
        return payroll;
    }

    public void setPayroll(List<Payroll> payroll) {
        this.payroll = payroll;
    }
}
