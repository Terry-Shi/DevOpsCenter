package com.terry.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.terry.domain.User;


@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
//	@Autowired
//	private LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(User user, BindingResult result, HttpSession session) {

		if ("USER".equalsIgnoreCase(user.getRole())) {
			boolean isSuccess = true;//loginService.checkUser(user);
			if(isSuccess){
				session.setAttribute("user", user);
				session.setAttribute("email", user.getEmail());
			}else{
				result.reject("login failed!");
			}
		}

		if (result.hasErrors()) {
			return "login";
		} else {
			return "redirect:index";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String processLogout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String processInitForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
}