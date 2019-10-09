package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
