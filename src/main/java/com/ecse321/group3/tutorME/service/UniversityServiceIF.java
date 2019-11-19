package com.ecse321.group3.tutorME.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecse321.group3.tutorME.domain.University;
@Service
public interface UniversityServiceIF {
	
    University createUniversity(University university) throws Exception;
    University getUniversity(String universityName) throws Exception;
    List<University> getUniversities() throws Exception;
    void deleteUniversity(String universityName) throws Exception;
	University updateUniversity(String oldId, University university) throws Exception;

}
