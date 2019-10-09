package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
