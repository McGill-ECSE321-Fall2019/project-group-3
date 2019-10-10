package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepo;

    @Test
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
