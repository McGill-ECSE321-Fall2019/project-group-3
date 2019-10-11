package com.ecse321.group3.tutorME.domain;
import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.repository.SubjectRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectTest {
		@Autowired
	    private SubjectRepository subjectRepo;
		@Autowired
	    private TestSuiteUtils testUtils;
		
		@Before
	    public void init(){
	        testUtils.truncateDatabase();
	    }
		
		@Test
		@Transactional
	    public void createSubject(){
	        Subject subject = new Subject();
	        University university = new University();
	        university.setUniversity_id(999);
	        Course course = new Course();
	        List<Course> courselist = new ArrayList<Course>();
	        List<University> universitylist = new ArrayList<University>();
	        courselist.add(course);
	        subject.setSubject_name("Biology");
	        subject.setUniversities(universitylist);
	        subject.setCourses(courselist);

	        try{
	            subjectRepo.save(subject);
	        } catch(Exception e){
	            Assert.fail(e.getMessage());
	        }
	    }

	    @Test
	    @Transactional
	    public void getSubject(){
	        createSubject();
	        Assert.assertEquals(1, subjectRepo.findAll().size());
	    }
	}


