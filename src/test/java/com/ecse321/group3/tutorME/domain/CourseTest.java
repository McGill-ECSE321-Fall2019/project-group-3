package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.CourseRepository;
import com.ecse321.group3.tutorME.service.CourseServiceIF;
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
	private CourseServiceIF courseService;
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
    public void createCourse(){
        Course course = new Course();
        course.setCourseName("ECSE321");

        try {
            courseService.createCourse(course);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getCourse() throws Exception{
        createCourse();
        Assert.assertEquals("ECSE321", courseService.getCourse("ECSE321").getCourseName());
    }
    
    @Test
    @Transactional
    public void updateCourse() throws Exception{
        createCourse();
        
        Course course = new Course();
        course.setCourseName("ECSE427");
        
        try {
        	courseService.updateCourse("ECSE321", course);
        }
        catch (Exception e) {
        	Assert.fail(e.getMessage());
        }
        
        try {
        	courseService.getCourse("ECSE321");
        }
        catch (Exception e) {
        	//all good.
        }
        
        Assert.assertEquals("ECSE427", courseService.getCourse("ECSE427").getCourseName());
    }
    
    @Test
    @Transactional
    public void getCourses() throws Exception {
    	createCourse();
    	Course course = new Course();
    	course.setCourseName("ECSE427");
    	courseService.createCourse(course);
    	
		Assert.assertEquals(2, courseService.getCourses().size());
    }
    
	@Test
	@Transactional
	public void deleteCourse() throws Exception{
		createCourse();
		courseService.deleteCourse("ECSE321");
		Assert.assertEquals(0, courseService.getCourses().size());
	}
}
