package org.example.UniversityRestAPI.Service;

import org.example.UniversityRestAPI.POJO.University;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class UniversityImpl1 implements UniversityService{
    private final RestTemplate restTemplate;
    private final TaskExecutor taskExecutor;
    private final TaskExecutor taskExecutor2;


    public UniversityImpl1(@Qualifier("restTemplate") RestTemplate restTemplate,
                           @Qualifier("threadPoolTaskExecutor") TaskExecutor taskExecutor,
                           @Qualifier("threadPoolTaskExecutor2") TaskExecutor taskExecutor2){
        this.restTemplate = restTemplate;
        this.taskExecutor = taskExecutor;
        this.taskExecutor2 = taskExecutor2;
    }

    @Override
    public List<University> getAllUniversity() {

        CompletableFuture<List<University>> cf = CompletableFuture.supplyAsync(() ->{
            ResponseEntity<University[]> resp;
            try{
                resp = restTemplate.getForEntity("http://universities.hipolabs.com/search", University[].class);
            }catch(RestClientException e){
                return Collections.emptyList();
            }

            // IDE says resp would always be not null
            if (resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null) return Collections.emptyList();

            return Arrays.asList(Objects.requireNonNull(resp.getBody()));
        }, taskExecutor);

        try {
            return cf.get();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    @Override
    public List<University> getUniversityByCountry(String country) {
        CompletableFuture<List<University>> cf = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<University[]> resp;
            try {
                resp = restTemplate.getForEntity("http://universities.hipolabs.com/search?country=" + country, University[].class);
            } catch (RestClientException e) {
                return Collections.emptyList();
            }

            // IDE says resp would always be not null
            if (resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null) return Collections.emptyList();

            return Arrays.asList(Objects.requireNonNull(resp.getBody()));
        }, taskExecutor2);

        try {
            return cf.get();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
