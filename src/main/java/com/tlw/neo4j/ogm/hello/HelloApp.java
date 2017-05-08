package com.tlw.neo4j.ogm.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 唐力伟 on 2017/5/6 0:00.
 */
@RestController
@SpringBootApplication
public class HelloApp {

    @RequestMapping("/")
    String index(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args){
        SpringApplication.run(HelloApp.class, args);
    }
}
