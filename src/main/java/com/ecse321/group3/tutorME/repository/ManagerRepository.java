package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
