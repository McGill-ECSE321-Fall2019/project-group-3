package com.ecse321.group3.tutorME.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ecse321.group3.tutorME.repository.UniversityRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityTest {
	
	@Autowired
    private UniversityRepository universityRepo;
	
	@Test
    public void createUniversity(){
        University uni = new University();
        uni.setUniversity_id(80);
        
        Course coursetest = new Course();
		coursetest.setCourseNumber(100);
		List<Course> courselist = new ArrayList<Course>();
		courselist.add(coursetest);
        
        List<Subject> subjectlist = new ArrayList<Subject>();
       Subject subjecttest = new Subject();
       subjecttest.setCourses(courselist);
       subjecttest.setSubject_name("biology");
       subjectlist.add(subjecttest);
       uni.setSubjects(subjectlist);
 
       

        try{
            universityRepo.save(uni);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getUniversity(){
        createUniversity();
        Assert.assertEquals(1, universityRepo.findAll().size());
    }
}
