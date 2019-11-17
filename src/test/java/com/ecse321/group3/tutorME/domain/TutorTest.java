//package com.ecse321.group3.tutorME.domain;
//
//import com.ecse321.group3.tutorME.repository.UserEntityRepository;
//import com.ecse321.group3.tutorME.service.TutorServiceIF;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
//import org.springframework.transaction.annotation.Transactional;
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class TutorTest {
//
//    @Autowired
//    private TutorServiceIF tutorService;
//	@Autowired
//    private UserRoleRepository userRoleRepo;
//    @Autowired
//    private UserEntityRepository userEntityRepository;
//	@Autowired
//    private TestSuiteUtils testUtils;
//
//	UserEntity userForTutor = null;
//	String emailForUser = "testemail@test.com";
//
//
//
//	@Before
//    public void init(){
//        testUtils.truncateDatabase();
//    }
//
//	@Test
//	@Transactional
//    public void createTutor(){
//        Tutor tutor = new Tutor();
//        tutor.setUserId(100);
//        userForTutor = new UserEntity();
//        userForTutor.setEmail(emailForUser);
//        userForTutor.setUserRole(tutor);
//
//        tutor.setUser(userForTutor);
//
//        try{
//            tutorService.createTutor(tutor);
//        } catch(Exception e){
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    @Test
//    @Transactional
//    public void getTutor() throws Exception {
//        Tutor tutor = new Tutor();
//        tutor.setUserId(100);
//
//        userForTutor = new UserEntity();
//        userForTutor.setEmail(emailForUser);
//        userForTutor.setUserRole(tutor);
//
//        tutor.setUser(userForTutor);
//        userEntityRepository.save(userForTutor);
//        Assert.assertEquals(emailForUser, tutorService.getTutor(emailForUser).getUser().getEmail());
//    }
//
//    @Test
//    @Transactional
//    public void updateTutor() throws Exception{
//        createTutor();
//        Tutor newTutor = new Tutor();
//        newTutor.setUserId(121);
//
//        Assert.assertEquals(1, tutorService.getTutors().size());
//
//        tutorService.updateTutor(emailForUser, newTutor);
//
//        Assert.assertEquals(1, tutorService.getTutors().size());
//    }
//    @Test
//    @Transactional
//    public void getAllTutors() throws Exception{
//        createTutor();
//        Assert.assertEquals(1, tutorService.getTutors().size());
//    }
//
//    @Test
//    @Transactional
//    public void deleteStudent() throws Exception{
//        UserEntity createUser = new UserEntity();
//        createUser.setEmail(emailForUser);
//        Tutor tutor = new Tutor();
//        createUser.setUserRole(tutor);
//        tutor.setUser(createUser);
//        tutorService.createTutor(tutor);
//        userEntityRepository.save(createUser);
//
//        userRoleRepo.deleteById(tutorService.getTutors().get(0).getUserId());
//        Assert.assertEquals(0, tutorService.getTutors().size());
//    }
//
//
//
//}
