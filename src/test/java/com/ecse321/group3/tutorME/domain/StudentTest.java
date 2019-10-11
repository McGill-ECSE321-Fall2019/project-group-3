package com.ecse321.group3.tutorME.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.domain.enums.ReviewAuthor;
import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.repository.ReviewRepository;
import com.ecse321.group3.tutorME.repository.StudentRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import com.ecse321.group3.tutorME.repository.*;
import com.ecse321.group3.tutorME.domain.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
	
	@Autowired
    private StudentRepository StudentEntityRepo;
	@Autowired
    private ReviewRepository ReviewEntityRepo;
	@Autowired
    private TutorRepository TutorEntityRepo;
	@Autowired
    private CourseRepository CourseEntityRepo;
	@Autowired
    private SubjectRepository SubjectEntityRepo;
	@Autowired
    private LessonRepository LessonEntityRepo;
	@Autowired
    private UniversityRepository UniversityEntityRepo;
	@Autowired
    private RoomRepository RoomEntityRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
    public void createStudentEntity(){
		Lesson lessontest = new Lesson();
		University universitytest = new University();
		Tutor testtutor = new Tutor();
		testtutor.setTutor_id(69);
		Subject subjecttest = new Subject();
		subjecttest.setSubject_name("hello");
		Course coursetest = new Course();
		coursetest.setCourseNumber(100);
		lessontest.setCourse(coursetest);
		lessontest.setLessonId(69);
        Student studentEntity = new Student();
        ReviewAuthor reviewauth = ReviewAuthor.TUTOR;
        List<Review> reviewslist = new ArrayList<Review>();
        Review studentReview = new Review (26,4,"test",testtutor,studentEntity,reviewauth);
       reviewslist.add(studentReview);
       testtutor.setReviews(reviewslist);
        studentEntity.setStudent_id(260759306);
        studentEntity.setReview(reviewslist);
        Room roomtest = new Room();
        roomtest.setRoom_id(20);
        lessontest.setCourse(coursetest);
        coursetest.setSubject(subjecttest);
        universitytest.setUniversity_id(69);
       

        try {
        	CourseEntityRepo.save(coursetest);
        	SubjectEntityRepo.save(subjecttest);
        	CourseEntityRepo.save(coursetest);
        	LessonEntityRepo.save(lessontest);
        	TutorEntityRepo.save(testtutor);
        	ReviewEntityRepo.save(studentReview);
            StudentEntityRepo.save(studentEntity);
            UniversityEntityRepo.save(universitytest);
            
            RoomEntityRepo.save(roomtest);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readStudentEntity(){
        createStudentEntity();
        Assert.assertEquals(1, StudentEntityRepo.findAll().size());
    }

}
