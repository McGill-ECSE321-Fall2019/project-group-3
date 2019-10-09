package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
