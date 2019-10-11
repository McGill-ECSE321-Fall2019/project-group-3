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

import com.ecse321.group3.tutorME.repository.TutorRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TutorTest {
	
	@Autowired
    private TutorRepository tutorRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
	@Transactional
    public void createTutor(){
        Tutor tutor = new Tutor();
        tutor.setRate(60);
        tutor.setTutor_id(123);
        
        Course coursetest = new Course();
		coursetest.setCourseNumber(100);
		List<Course> courselist = new ArrayList<Course>();
		courselist.add(coursetest);
        tutor.setCoursesTaught(courselist);
        Review review1 = new Review();
        review1.setRating(4);
        review1.setComment("Hello this is my comment");
        List<Review> reviewlist = new ArrayList<Review>();
        reviewlist.add(review1);
        tutor.setReviews(reviewlist);
        Schedule schedule = new Schedule();
        schedule.setSchedule_id(900);
        tutor.setSchedule(schedule);
 
       

        try{
            tutorRepo.save(tutor);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getTutor(){
       createTutor();
        Assert.assertEquals(1, tutorRepo.findAll().size());
    }
	
	
}
