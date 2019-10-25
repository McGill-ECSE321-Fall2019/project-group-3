package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.LessonRepository;
import com.ecse321.group3.tutorME.service.LessonServiceIF;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    @Test
    @Transactional
    public void createLesson(){
        Lesson lesson = new Lesson();
        lesson.setLessonId(5);
        try{
            lessonService.createLesson(lesson);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getLesson() throws Exception {
        createLesson();
        Assert.assertEquals(5, lessonService.getLesson(5).getLessonId());
    }

    @Test
    @Transactional
    public void updateLesson() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setLessonId(5);

        lessonService.createLesson(lesson);
        System.out.println(lessonService.getLesson(5).getLessonId());

        Lesson newLesson = new Lesson();
        newLesson.setLessonId(10);

        try {
            lessonService.updateLesson(5, newLesson);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        try {
            lessonService.getLesson(5);
        } catch(Exception e){
            //all good.
        }
        Assert.assertEquals(10, lessonService.getLesson(10).getLessonId());
    }

    @Test
    @Transactional
    public void getAllLessons() throws Exception{
        createLesson();
        Lesson newLesson = new Lesson();
        newLesson.setLessonId(10);
        lessonService.createLesson(newLesson);

        Assert.assertEquals(2, lessonService.getLessons().size());
    }
    @Test
    @Transactional
    public void deleteLesson() throws Exception{
        createLesson();
        lessonService.deleteLesson(5);
        Assert.assertEquals(0, lessonService.getLessons().size());
    }


}
