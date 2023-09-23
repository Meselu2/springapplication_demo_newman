package com.example.springapplication_demo_newman.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class EvenOddRepositoryImpl implements EvenOddRepository{


    private final RestTemplate restTemplate;

    @Value("${springapplication.demo.baseUrl}")
    private String path;
    @Override
    @Profile("local")
    public Integer findTheeLengthOfName(String name) {



        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<Integer> responseEntity =restTemplate.exchange(path+"/name-length?name="+name
        , HttpMethod.GET,new HttpEntity<>(httpHeaders),Integer.class);
        return responseEntity.getBody();
    }
}
