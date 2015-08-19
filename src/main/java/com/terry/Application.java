package com.terry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * http://kielczewski.eu/2014/04/spring-boot-mvc-application/
 *
 */
@EnableAutoConfiguration
//@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
//        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(…); // such as ApplicationStartedEvent
//        app.setShowBanner(false);
//        app.run(args);
    }

}
