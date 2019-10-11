package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseTest {

    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @Test
    @Transactional
    public void saveCourse(){
        List<University> universityList = new ArrayList<>();
        universityList.add(new University());

        Course course = new Course();
        course.setCourseNumber(240);
        course.setLessons(new ArrayList<Lesson>());
        course.setSubject(new Subject());

        try {
            courseRepo.save(course);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readCourse(){
        saveCourse();
        Assert.assertEquals(1, courseRepo.findAll().size());
    }
}
