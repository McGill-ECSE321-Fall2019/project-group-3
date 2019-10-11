package com.ecse321.group3.tutorME.utils;

import com.ecse321.group3.tutorME.repository.*;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.repository.TutorRepository;
import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSuiteUtils {

    //Autowire all repositories.

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private LessonRepository lessonRepo;

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private SubjectRepository subjectRepo;

    @Autowired
    private TutorRepository tutorRepo;

    @Autowired
    private UniversityRepository uniRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private ManagerRepository managerRepo;
    

    public void truncateDatabase(){
    	subjectRepo.deleteAll();
    	courseRepo.deleteAll();
    	lessonRepo.deleteAll();
    	uniRepo.deleteAll();
    	roomRepo.deleteAll();
    	payrollRepo.deleteAll();
    	scheduleRepo.deleteAll();
    	reviewRepo.deleteAll();
    	managerRepo.deleteAll();
        studentRepo.deleteAll();
        tutorRepo.deleteAll();
        userEntityRepository.deleteAll();
        
       
        
    }
    
}
