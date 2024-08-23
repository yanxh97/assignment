package org.example.UniversityRestAPI.Service;

import org.example.UniversityRestAPI.POJO.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UniversityImpl1 implements UniversityService{
    private final RestTemplate restTemplate;

    public UniversityImpl1(@Qualifier("restTemplate") RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<University> getAllUniversity() {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);

        ResponseEntity<University[]> resp = restTemplate.getForEntity("http://universities.hipolabs.com/search", University[].class);

        if (resp.getStatusCode() != HttpStatus.OK) return Collections.emptyList();
        if (resp.getBody() == null) return Collections.emptyList();

        return Arrays.asList(Objects.requireNonNull(resp.getBody()));
    }

    @Override
    public List<University> getUniversityByCountry(String country) {
        ResponseEntity<University[]> resp = restTemplate.getForEntity("http://universities.hipolabs.com/search?country=" + country, University[].class);

        if (resp.getStatusCode() != HttpStatus.OK) return Collections.emptyList();
        if (resp.getBody() == null) return Collections.emptyList();

        return Arrays.asList(Objects.requireNonNull(resp.getBody()));
    }
}
