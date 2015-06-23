package com.terry.bean;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements ExitCodeGenerator{

    @PreDestroy
    public void preDestory() {
        System.out.println("---------- MyBean.preDestory() ----------");
    }
    
    @Override
    public int getExitCode() {
        System.out.println("---------- MyBean.getExitCode() ----------");
        return 0;
    }

    // Property from external 
    @Value("${app.description}")
    private String name;
    
    
    
}
