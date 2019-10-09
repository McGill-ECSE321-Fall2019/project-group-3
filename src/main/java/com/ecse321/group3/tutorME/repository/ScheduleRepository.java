package com.ecse321.group3.tutorME.repository;

import com.ecse321.group3.tutorME.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
