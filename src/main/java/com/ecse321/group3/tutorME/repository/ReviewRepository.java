package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Student;
import com.ecse321.group3.tutorME.domain.Tutor;
import com.ecse321.group3.tutorME.domain.UserEntity;
import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecse321.group3.tutorME.domain.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByTutorAndReviewAuthor(Tutor tutor, ReviewAuthor reviewAuthor);
    List<Review> findByStudentAndReviewAuthor(Student student, ReviewAuthor reviewAuthor);
}
