package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserRoleRepository;
import com.ecse321.group3.tutorME.service.StudentServiceIF;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
	
	@Autowired
	private StudentServiceIF studentService;

	
	@Autowired
    private UserRoleRepository StudentEntityRepo;

	@Autowired
    private TestSuiteUtils testUtils;
	
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
    @Transactional
    public void createStudent(){
		Student studentEntity = new Student();
		studentEntity.setUserId(1);

        try {
            studentService.createStudent(studentEntity);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
	
	@Test
    @Transactional
    public void getStudent() throws Exception {
        createStudent();
        Assert.assertEquals(1, studentService.getStudent(1).getStudentId());
    }

    @Test
    @Transactional
    public void readStudentEntity(){
        createStudentEntity();
        Assert.assertEquals(1, StudentEntityRepo.findAll().size());
    }

}
