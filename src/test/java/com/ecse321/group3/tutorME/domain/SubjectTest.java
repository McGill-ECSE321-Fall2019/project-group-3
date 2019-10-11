package com.ecse321.group3.tutorME.domain;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecse321.group3.tutorME.repository.ScheduleRepository;
import com.ecse321.group3.tutorME.repository.SubjectRepository;

public class SubjectTest {
	@SpringBootTest
	public class ScheduleTest {
		@Autowired
	    private SubjectRepository subjectRepo;
		
		@Test
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
	    public void getSubject(){
	        createSubject();
	        Assert.assertEquals(1, subjectRepo.findAll().size());
	    }
	}

}
