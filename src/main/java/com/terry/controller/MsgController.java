package com.terry.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
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

import com.terry.domain.MsgBox;
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
    @Autowired
    private HttpSession httpSession;
    
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        return new ModelAndView("msg_create", "form", new MsgBox());
    }
    
    @RequestMapping(value = "/sender", method = RequestMethod.POST)
    public String createMsg(@ModelAttribute("form") @Valid MsgBox form, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.info("Msg validate failed: " + result.toString());
            return "msg_sender";
        }
        try {
            User user = (User)httpSession.getAttribute("USER");
            form.setFromUser(user.getId());
            form.setCreateTime(new Date());
            form.setStatus("NOT_READ");
            msgBoxService.save(form); 
        } catch (Exception e) {
            result.reject("msg.error.create");
            return "msg_sender";
        }
        return "redirect:/msg_list";
    } 

}
