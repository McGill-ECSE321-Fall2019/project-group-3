package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, String> {
}
