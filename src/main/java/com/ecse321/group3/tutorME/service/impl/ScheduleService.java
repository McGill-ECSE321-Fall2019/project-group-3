package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Schedule;
import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.service.ScheduleServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ScheduleService implements ScheduleServiceIF {

    @Autowired
    private ScheduleRepository scheduleRepo;

    @Override
    public Schedule createSchedule(Schedule schedule) throws Exception {
        Schedule scheduleCreated = null;

        try {
            scheduleCreated = scheduleRepo.save(schedule);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return scheduleCreated;
    }

    @Override
    public Schedule getSchedule(int id) throws Exception {
        Schedule scheduleCreated = null;

        try {
            scheduleCreated = scheduleRepo.findById(id).get();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return scheduleCreated;    
        }

    @Override
    public List<Schedule> getSchedules() throws Exception {
        List<Schedule> schedules = null;

        try {
            schedules = scheduleRepo.findAll();
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return schedules;     
        }

    @Override
    public void deleteSchedule(int id) throws Exception {
        try {
            scheduleRepo.deleteById(id);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return; 
    }

    @Override
    public Schedule updateSchedule(int oldId, Schedule schedule) throws Exception {
        Schedule scheduleUpdated = null;
        try {
            scheduleRepo.deleteById(oldId);
            scheduleUpdated = scheduleRepo.save(schedule);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return scheduleUpdated; 
    }
}