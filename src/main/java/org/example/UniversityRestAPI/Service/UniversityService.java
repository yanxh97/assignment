package org.example.UniversityRestAPI.Service;

import org.example.UniversityRestAPI.POJO.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {
    List<University> getAllUniversity();
    List<University> getUniversityByCountry(String country);
}
