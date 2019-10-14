package com.ecse321.group3.tutorME.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="manager")
public class Manager extends UserRole {

    public Manager() {
    }

    public Manager(List<Payroll> payroll) {
        this.payroll = payroll;
    }

    @OneToMany(mappedBy = "manager")
    private List<Payroll> payroll;

    public List<Payroll> getPayroll() {
        return payroll;
    }

    public void setPayroll(List<Payroll> payroll) {
        this.payroll = payroll;
    }
}
