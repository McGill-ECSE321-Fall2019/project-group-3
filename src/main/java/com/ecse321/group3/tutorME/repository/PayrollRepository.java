package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}
