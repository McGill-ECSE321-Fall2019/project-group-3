package com.ecse321.group3.tutorME;

import com.ecse321.group3.tutorME.repository.CourseRepository;
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
    

    public void truncateDatabase(){
        userEntityRepository.deleteAll();
        roomRepo.deleteAll();
        courseRepo.deleteAll();
    }
    
}
