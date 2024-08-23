package org.example.UniversityRestAPI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyRestTemplateConfig {

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(/*RestTemplateBuilder builder*/){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }
}
