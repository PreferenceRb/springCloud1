package com.example.demo.message;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kobe on 2018/11/9.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
       return new Queue("hello");
    }

}
