package com.terry;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * http://kielczewski.eu/2014/04/spring-boot-mvc-application/
 *
 */
//@RestController
@Controller
@EnableAutoConfiguration
//@SpringBootApplication
@ComponentScan
public class Example {

    private String message = "Hello World!!!";
    
//    @RequestMapping("/index")
//    String home() {
//        return "index";
//    }
//
//    @RequestMapping("/welcome")
//    public String welcome(Map<String, Object> model) {
//        model.put("time", new Date());
//        model.put("message", this.message);
//        return "welcome";
//    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
