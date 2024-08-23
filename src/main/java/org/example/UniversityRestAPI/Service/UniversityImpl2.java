package org.example.UniversityRestAPI.Service;

import org.example.UniversityRestAPI.POJO.University;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UniversityImpl2 implements UniversityService{
    @Override
    public List<University> getAllUniversity() {
        University res = new University();
        res.setCountry("Not A Default Country impl2");
        return Arrays.asList(res, new University());
    }

    @Override
    public List<University> getUniversityByCountry(String country) {
        University res = new University();
        res.setCountry(country);
        return Collections.singletonList(res);
    }
}
