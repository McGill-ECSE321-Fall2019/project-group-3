package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	UserRole findByUserEmailAddress(String emailAddress);
}
