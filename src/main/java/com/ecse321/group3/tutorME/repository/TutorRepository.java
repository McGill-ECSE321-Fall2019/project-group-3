package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}
