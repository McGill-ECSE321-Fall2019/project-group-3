package com.ecse321.group3.tutorME.service;

import com.ecse321.group3.tutorME.domain.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonServiceIF {

    //Creating an interface for all the methods a lesson will have.
    Lesson createLesson(Lesson lesson) throws Exception;
    Lesson getLesson(int lessonId) throws Exception;
    List<Lesson> getLessons() throws Exception;
    Lesson updateLesson(int oldId, Lesson lesson) throws Exception;
    void deleteLesson(int lessonId) throws Exception;
}

