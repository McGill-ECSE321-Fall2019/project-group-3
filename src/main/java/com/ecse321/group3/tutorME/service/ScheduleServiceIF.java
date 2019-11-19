package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleServiceIF {

    Schedule createSchedule(Schedule schedule) throws Exception;
    Schedule getSchedule(int id) throws Exception;
    List<Schedule> getSchedules() throws Exception;
    Schedule updateSchedule(int oldId, Schedule schedule) throws Exception;
    void deleteSchedule(int id) throws Exception;
}
