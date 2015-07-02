package com.terry.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.terry.domain.User;

@RestController
@RequestMapping(value = "/users")
public class MyRestController {
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId+"");
        user.setPassword("psw!");
        return user;
    }

//    @RequestMapping(value = "/{userId}/customers", method = RequestMethod.GET)
//    List<Customer> getUserCustomers(@PathVariable Long userId) {
//        // ...
//    }
//
//    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
//    public User deleteUser(@PathVariable Long userId) {
//        // ...
//    }

}
