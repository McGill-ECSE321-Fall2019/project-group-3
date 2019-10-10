package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.LessonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class LessonTest {

    @Autowired
    private LessonRepository lessonRepo;

    @Test
    public void createLesson(){
        Lesson lesson = new Lesson();

        Course course = new Course();
        Subject subject = new Subject();
        subject.setSubjectName("MATH");
        subject.setUniversities(new ArrayList<University>());

        lesson.setCourse(course);

        try{
            lessonRepo.save(lesson);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readLesson(){
        createLesson();
        Assert.assertEquals(1, lessonRepo.findAll().size());
    }
}
