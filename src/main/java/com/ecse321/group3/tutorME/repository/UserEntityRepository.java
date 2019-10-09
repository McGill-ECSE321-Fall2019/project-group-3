package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
}
