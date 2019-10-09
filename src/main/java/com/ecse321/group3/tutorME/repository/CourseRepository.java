package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
