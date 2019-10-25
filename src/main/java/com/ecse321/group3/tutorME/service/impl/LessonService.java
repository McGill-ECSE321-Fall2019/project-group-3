package com.ecse321.group3.tutorME.service.impl;

import com.ecse321.group3.tutorME.domain.Lesson;
import com.ecse321.group3.tutorME.domain.Subject;
import com.ecse321.group3.tutorME.domain.University;
import com.ecse321.group3.tutorME.repository.LessonRepository;
import com.ecse321.group3.tutorME.service.LessonServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LessonService implements LessonServiceIF {

    @Autowired
    private LessonRepository lessonRepo;

    @Override
    public Lesson createLesson(Lesson lesson) throws Exception {
        //THIS METHOD WILL DO THE ACTUAL CODE IMPLEMENTATION.
        Lesson lessonCreated = null;

        //create the lesson, by saving to the database.
        try {
        	lessonCreated = lessonRepo.save(lesson);
        } catch(Exception e){
            //if we get errors saving to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the lesson we created.
        return lessonCreated;
    }

    @Override
    public Lesson getLesson(int lessonId) throws Exception {
        Lesson lessonCreated = null;

        //create the lesson, by saving to the database.
        try {
            lessonCreated = lessonRepo.findById(lessonId).get();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the lesson we created.
        return lessonCreated;    
        }

    @Override
    public List<Lesson> getLessons() throws Exception {
        List<Lesson> lessons = null;

        //create the lesson, by saving to the database.
        try {
            lessons = lessonRepo.findAll();
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }

        //or else return the lesson we created.
        return lessons;     
        }

    @Override
    public Lesson updateLesson(int oldId, Lesson lesson) throws Exception {
        Lesson lesson_updated = null;

        try {
            lessonRepo.deleteById(oldId);
            lesson_updated = lessonRepo.save(lesson);
        }catch (Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return lesson_updated;
    }

    @Override
    public void deleteLesson(int lessonId) throws Exception {
        //delete the lesson

        try {
            lessonRepo.deleteById(lessonId);
        } catch(Exception e){
            //if we get errors getting to database, throw an exception
            throw new Exception(e.getMessage());
        }
        return; 
    }


}