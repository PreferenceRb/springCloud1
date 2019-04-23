package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kobe on 2018/10/9.
 */
@RestController
public class DemoController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World!";
    }
}
