package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.LessonRepository;
import com.ecse321.group3.tutorME.service.LessonServiceIF;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class LessonTest {

    @Autowired
    private LessonRepository lessonRepo;

    @Autowired
    private LessonServiceIF lessonService;

    @Autowired
    private TestSuiteUtils testUtils;
    
    @Before
    public void init(){
        testUtils.truncateDatabase();
    }

    @After
    public void clean(){testUtils.truncateDatabase();}

    @Test
    @Transactional
    public void createLesson(){
        Lesson lesson = new Lesson();
        try{
            lessonService.createLesson(lesson);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }



    @Test
    @Transactional
    public void updateLesson() throws Exception {
       Lesson lesson = new Lesson();
       LocalDate date = LocalDate.of(2019,10,03);
       lesson.setStartTime(date);


        lessonService.createLesson(lesson);

        Lesson newLesson = new Lesson();
        date = LocalDate.now();
        newLesson.setStartTime(date);

        try {
            lessonService.updateLesson(lessonService.getLessons().get(0).getLessonId(), newLesson);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals(date, lessonService.getLessons().get(0).getStartTime());
    }

    @Test
    @Transactional
    public void getAllLessons() throws Exception{
        createLesson();
        Lesson newLesson = new Lesson();
        lessonService.createLesson(newLesson);

        Assert.assertEquals(2, lessonService.getLessons().size());
    }



}
