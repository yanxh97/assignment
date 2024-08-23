package org.example.UniversityRestAPI.Controller;

import org.example.UniversityRestAPI.POJO.University;
import org.example.UniversityRestAPI.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {


    private final UniversityService universityService;

    //@Autowired
    public UniversityController(
            @Qualifier("universityImpl1")
            UniversityService universityService){
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<List<University>> getAllUniversity() {
        List<University> res = universityService.getAllUniversity();
        if (res == null || res.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<University>> getUniversityByCountry(@PathVariable("country") String country){
        List<University> res = universityService.getUniversityByCountry(country);
        if (res == null || res.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
