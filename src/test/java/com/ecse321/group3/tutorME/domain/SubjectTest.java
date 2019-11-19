package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.service.SubjectServiceIF;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.repository.SubjectRepository;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectTest {

		@Autowired
		private SubjectServiceIF subjectService;

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
	        subject.setSubject_name("Biology");

	        try{
	            subjectService.createSubject(subject);
	        } catch(Exception e){
	            Assert.fail(e.getMessage());
	        }
	    }

	    @Test
	    @Transactional
	    public void getSubject() throws Exception {
	        createSubject();
	        Assert.assertEquals("Biology", subjectService.getSubject("Biology").getSubject_name());
	    }

		@Test
		@Transactional
		public void updateSubject() throws Exception {
			createSubject();

			Subject newSubject = new Subject();
			newSubject.setSubject_name("Math");

			try {
				subjectService.updateSubject("Biology", newSubject);
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}

			try {
				subjectService.getSubject("Biology");
			} catch(Exception e){
				//all good.
			}
			Assert.assertEquals("Math", subjectService.getSubject("Math").getSubject_name());
		}

		@Test
		@Transactional
		public void getAllSubjects() throws Exception{
			createSubject();
			Subject newSubject = new Subject();
			newSubject.setSubject_name("Math");
			subjectService.createSubject(newSubject);

			Assert.assertEquals(2, subjectService.getSubjects().size());
		}

		@Test
		@Transactional
		public void deleteSubject() throws Exception{
			createSubject();
			subjectService.deleteSubject("Biology");
			Assert.assertEquals(0, subjectService.getSubjects().size());
		}
}


