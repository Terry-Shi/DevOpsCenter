package com.terry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.terry.service.UserService;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;


    // approach 1
    @RequestMapping("/user_list")
    public ModelAndView getListUsersView() {
        ModelMap model = new ModelMap();
        model.addAttribute("users", userService.getList());
        return new ModelAndView("user_list", model);
    }
    
    // approach 2
//    @RequestMapping("/user_list.html")
//    public String getListUsersView(Model model) {
//        model.addAttribute("users", userService.getList());
//        return "user_list";
//    }

    // approach 3
//    @ModelAttribute("users")
//    List<User> getUserList() {
//        return userService.getList();
//    }
//
//    @RequestMapping("/user_list.html")
//    public String getListUsersView() {
//        return "user_list";
//    }
    
    
    
}