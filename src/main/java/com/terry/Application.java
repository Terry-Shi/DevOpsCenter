package com.terry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动入口类
 * 参考例子 http://kielczewski.eu/2014/04/spring-boot-mvc-application/
 *
 */
@SpringBootApplication // 包含三个annotation加起来的效果  @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
//        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(…); // such as ApplicationStartedEvent
//        app.setShowBanner(false); // 等效于spring.main.show_banner=false
//        app.run(args);
    }

}
