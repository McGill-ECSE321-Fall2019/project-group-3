package com.ecse321.group3.tutorME.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ecse321.group3.tutorME.repository.UniversityRepository;
import com.ecse321.group3.tutorME.service.UniversityServiceIF;
import com.ecse321.group3.tutorME.utils.TestSuiteUtils;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityTest {
	
	@Autowired
	private UniversityServiceIF universityService;
	@Autowired
    private UniversityRepository universityRepo;
	@Autowired
    private TestSuiteUtils testUtils;
	@Before
    public void init(){
        testUtils.truncateDatabase();
    }
	
	@Test
	@Transactional
    public void createUniversity(){
        University uni = new University();
        uni.setUniversity_name("McGill");

        try{
            universityRepo.save(uni);
        } catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getUniversity(){
        createUniversity();
        Assert.assertEquals(1, universityRepo.findAll().size());
    }
    
    @Test
	@Transactional
	public void updateUniversity() throws Exception {
		createUniversity();

		University newUniversity = new University();
		newUniversity.setUniversity_name("Concordia");

		try {
			universityService.updateUniversity("McGill", newUniversity);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {
			universityService.getUniversity("McGill");
		} catch(Exception e){
		}
		Assert.assertEquals("Concordia", universityService.getUniversity("Concordia").getUniversity_name());
	}

	@Test
	@Transactional
	public void getAllUniversities() throws Exception{
		createUniversity();
		University newUniversity = new University();
		newUniversity.setUniversity_name("Toronto");
		universityService.createUniversity(newUniversity);

		Assert.assertEquals(2, universityService.getUniversities().size());
	}

	@Test
	@Transactional
	public void deleteUniversity() throws Exception{
		createUniversity();
		universityService.deleteUniversity("McGill");
		Assert.assertEquals(0, universityService.getUniversities().size());
	}


}



