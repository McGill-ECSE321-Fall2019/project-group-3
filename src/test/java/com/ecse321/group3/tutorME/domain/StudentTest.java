package com.ecse321.group3.tutorME.domain;

import com.ecse321.group3.tutorME.repository.UserEntityRepository;
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
    private UserEntityRepository userEntityRepository;

	
	
	UserEntity userForStudent = null;
	String emailForUser = "testemail@test.com";

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
		studentEntity.setUserId(100);
		userForStudent = new UserEntity();
        userForStudent.setEmail(emailForUser);
		userForStudent.setUserRole(studentEntity);

		studentEntity.setUser(userForStudent);


		try{
            studentService.createStudent(studentEntity);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
	
	 @Test
	    @Transactional
	    public void getStudent() throws Exception {
	        Student student = new Student();
	        student.setUserId(100);

	        userForStudent = new UserEntity();
	        userForStudent.setEmail(emailForUser);
	        userForStudent.setUserRole(student);

	        student.setUser(userForStudent);
	        userEntityRepository.save(userForStudent);
	        Assert.assertEquals(emailForUser, studentService.getStudent(emailForUser).getUser().getEmail());
	    }

	    @Test
	    @Transactional
	    public void updateStudent() throws Exception{
		    createStudent();
		    Student newStudent = new Student();
		    newStudent.setUserId(121);

		    Assert.assertEquals(1, studentService.getStudents().size());

		    studentService.updateStudent(emailForUser, newStudent);

		    Assert.assertEquals(1, studentService.getStudents().size());
	    }

	    @Test
	    @Transactional
	    public void getAllStudents() throws Exception{
	        createStudent();
	        Assert.assertEquals(1, studentService.getStudents().size());
	    }

	    @Test
	    @Transactional
	    public void deleteStudent() throws Exception{
		    UserEntity createUser = new UserEntity();
		    createUser.setEmail(emailForUser);
		    Student student = new Student();
		    createUser.setUserRole(student);
	        student.setUser(createUser);
	        studentService.createStudent(student);
		    userEntityRepository.save(createUser);

		    userRoleRepo.deleteById(studentService.getStudents().get(0).getUserId());
		    Assert.assertEquals(0, studentService.getStudents().size());
	    }

		}