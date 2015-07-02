package com.terry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terry.domain.User;

@Controller
@RequestMapping(value = "/static")
public class MyController {
    
    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public String getUser() {
        return "bootstrap\\minimal";
    }
}
