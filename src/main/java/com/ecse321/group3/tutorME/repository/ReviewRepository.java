package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
