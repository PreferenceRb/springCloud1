package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kobe on 2018/10/14.
 */
@RestController
public class CusumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return demoService.demo();
    }
}
