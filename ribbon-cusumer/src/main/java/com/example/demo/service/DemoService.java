package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kobe on 2018/10/20.
 */
@Service
public class DemoService {

    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error")
    public String demo(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://compute-service/test",String.class);
        return response.getBody();
    }
    public String error(){
        return "error";
    }
}
