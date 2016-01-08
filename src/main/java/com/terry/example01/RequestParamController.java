package com.terry.example01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.terry.contacts.Contact;

@Controller
@RequestMapping("/requestparam")
public class RequestParamController {

	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
	    model.put("firstName", "set param firstname");
	    model.put("lastName", "set param lastname");
		return "RequestParam2";
	}

//	@RequestMapping(method=RequestMethod.POST)
//	public String submit(@RequestParam("inputtext") String inputtext, 
//	        @RequestParam("result") String result) {
//	    System.out.println(" ****** bind to Variable ****** ");
//	    System.out.println(inputtext);
//	    System.out.println(result);
//		return "redirect:/RequestParam";// why 404
//	}
	
//   @RequestMapping(method=RequestMethod.POST)
//    public String submit(Contact contact) {
//	      System.out.println(" ****** bind to POJO ****** " + contact);
//        System.out.println(contact.getFirstName());
//        System.out.println(contact.getLastName());
//        return "RequestParam";// why 404
//    }
	
   @RequestMapping(method=RequestMethod.POST)
   public String submit(Model model) {
       System.out.println(" ****** bind to Model ****** " + model);
//       Contact contact = model.get("")
//       System.out.println(contact.getFirstName());
//       System.out.println(contact.getLastName());
       return "RequestParam2";// why 404
   }
   
//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(Map<String,Object> model) {
//       System.out.println(" ****** bind to Map ****** " + model);
//       System.out.println(model.get("firstName"));
//       System.out.println(model.get("lastName"));
//       return "redirect:/requestparam";
//   }
   
//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//       System.out.println(" ****** bind to HttpServletRequest ****** ");
//       System.out.println(request.getParameterNames());
//       String firstName = WebUtils.findParameterValue(request, "firstname");
//       String lastName = WebUtils.findParameterValue(request, "lastname");
//       System.out.println(firstName);
//       System.out.println(lastName);
//       return "redirect:/requestparam";
//   }
}