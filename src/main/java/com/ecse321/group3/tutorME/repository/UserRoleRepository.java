package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByUserEmail(String email);
    List<UserRole> deleteByUserEmail(String email);
}
