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
    private UserRoleRepository userRoleRepo;

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
		studentEntity.getUser().setEmail("hello");

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
        Assert.assertEquals(1, userRoleRepo.findAll().size());
    }

	@Test
	@Transactional
	public void updateStudent() throws Exception {
		createStudent();

		Student newStudent = new Student();
		newStudent.getUser().setEmail("hello2");

		try {
			studentService.updateStudent("hello", newStudent);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {
			studentService.getStudent("hello");
		} catch(Exception e){
		}
		Assert.assertEquals("hello2", studentService.getStudent("hello2").getUser().getEmail());
	}
	
	@Test
	@Transactional
	public void getAllStudents() throws Exception{
		createStudent();
		Student newStudent = new Student();
		newStudent.getUser().setEmail("hello3");
		studentService.createStudent(newStudent);

		Assert.assertEquals(2, studentService.getStudents().size());
	}

	@Test
	@Transactional
	public void deleteStudent() throws Exception{
		createStudent();
		studentService.deleteStudent("hello");
		Assert.assertEquals(0, studentService.getStudents().size());
	}
}
