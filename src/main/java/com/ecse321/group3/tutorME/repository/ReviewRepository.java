package com.ecse321.group3.tutorME.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecse321.group3.tutorME.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
