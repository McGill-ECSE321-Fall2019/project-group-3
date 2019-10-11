package com.ecse321.group3.tutorME;

import com.ecse321.group3.tutorME.repository.*;
import com.ecse321.group3.tutorME.repository.RoomRepository;
import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.repository.TutorRepository;
import com.ecse321.group3.tutorME.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired ManagerRepository managerRepo;
    

    public void truncateDatabase(){
        userEntityRepository.deleteAll();
        roomRepo.deleteAll();
        courseRepo.deleteAll();
        lessonRepo.deleteAll();
        managerRepo.deleteAll();
        payrollRepo.deleteAll();
        reviewRepo.deleteAll();
        roomRepo.deleteAll();
        studentRepo.deleteAll();
        scheduleRepo.deleteAll();
        uniRepo.deleteAll();
        subjectRepo.deleteAll();
    }
    
}
