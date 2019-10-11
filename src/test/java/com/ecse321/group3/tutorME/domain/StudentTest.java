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
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
	
	@Autowired
    private StudentRepository StudentEntityRepo;

	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
    @Transactional
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
        Review studentReview = new Review ();
        studentReview.setComment("test");
        studentReview.setRating(4);
        studentReview.setReviewAuthor(ReviewAuthor.TUTOR);
        studentReview.setTutor(testtutor);
        studentReview.setStudent(studentEntity);
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
            StudentEntityRepo.save(studentEntity);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void readStudentEntity(){
        createStudentEntity();
        Assert.assertEquals(1, StudentEntityRepo.findAll().size());
    }

}
