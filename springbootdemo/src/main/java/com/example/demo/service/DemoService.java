package com.example.demo.service;

import com.example.demo.vo.StudentVo;
import org.springframework.stereotype.Service;

/**
 * Created by kobe on 2018/10/20.
 */
@Service
public class DemoService implements  IDemoService {
    public String demo(){
        return "hello world";
    }

    @Override
    public void testStudent(StudentVo studentVo) {
        System.out.println("run method testStudent");
    }
}
