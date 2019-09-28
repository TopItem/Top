package com.top.demo;

import org.springframework.scheduling.annotation.EnableAsync;;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableAsync
@EnableCaching
@CrossOrigin
@SpringBootApplication
public class TopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopApplication.class, args);
    }


}
