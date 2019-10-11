package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}
