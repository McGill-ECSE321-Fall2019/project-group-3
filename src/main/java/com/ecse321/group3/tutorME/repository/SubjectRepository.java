package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
