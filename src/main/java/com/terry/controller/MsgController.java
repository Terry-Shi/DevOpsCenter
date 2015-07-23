package com.terry.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.terry.domain.User;
import com.terry.domain.UserCreateForm;
import com.terry.exception.UserAlreadyExistsException;
import com.terry.service.MsgBoxService;
import com.terry.service.UserService;
import com.terry.validator.UserCreateFormPasswordValidator;

@Controller
@RequestMapping(value = "/msg")
public class MsgController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MsgController.class);
    
    @Autowired
    private MsgBoxService msgBoxService;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMsg(@ModelAttribute("form") @Valid UserCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.info("User Form validate failed: " + result.toString());
            return "user_create";
        }
        try {
            msgBoxService.save(new User(form.getId(), form.getPassword2())); 
        } catch (UserAlreadyExistsException e) {
            result.reject("user.error.exists");
            return "user_create";
        }
        return "redirect:/user_list";
    }

}
