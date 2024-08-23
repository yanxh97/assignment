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
        return new ResponseEntity<>(universityService.getAllUniversity(), HttpStatus.OK);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<University>> getUniversityByCountry(@PathVariable("country") String country){
        return new ResponseEntity<>(universityService.getUniversityByCountry(country), HttpStatus.OK);
    }


}
