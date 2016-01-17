package com.terry.example01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.terry.contacts.Contact;

@Controller
@RequestMapping("/requestparam")
public class RequestParamController {

    //***************************************************************
    //               Controller -> web page
    //***************************************************************
//	@RequestMapping(method=RequestMethod.GET)
//	public String home(Map<String,Object> model) {
//	    model.put("firstName", "set param firstname");
//	    model.put("lastName", "set param lastname");
//		return "RequestParam";
//	}
	
//    @RequestMapping(method=RequestMethod.GET)
//    public String home(Model model) {
//        model.addAttribute("firstName", "set param firstname in Model");
//        model.addAttribute("lastName", "set param lastname in Model");
//        return "RequestParam";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView home(ModelAndView model) {
//        model.getModel().put("firstName", "set param firstname in ModelAndView");
//        model.getModel().put("lastName", "set param lastname in ModelAndView");
//        model.setViewName("RequestParam");
//        return model;
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(@ModelAttribute("contact") Contact contact) {
        System.out.println(contact);
        contact.setFirstName("set param firstname in POJO");
        contact.setLastName("set lastname in POJO");
        return "RequestParam";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView home(ModelAndView model) {
//        Contact contact = new Contact();
//        contact.setFirstName("set param firstname in ModelAndView.POJO");
//        contact.setLastName("set lastname in ModelAndView.POJO");
//        model.getModel().put("contact", contact);
//        model.setViewName("RequestParam");
//        return model;
//    }
    
    
    //***************************************************************
    //               Controller -> client
    //***************************************************************
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@RequestParam("firstName") String inputtext, 
	        @RequestParam("lastName") String result) {
	    System.out.println(" ****** bind to Variable ****** ");
	    System.out.println(inputtext);
	    System.out.println(result);
		return "RequestParam"; 
	}
	
//   @RequestMapping(method=RequestMethod.POST)
//    public String submit(Contact contact) {
//	    System.out.println(" ****** bind to POJO ****** " + contact);
//        System.out.println(contact.getFirstName());
//        System.out.println(contact.getLastName());
//        return "RequestParam";
//    }

//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(Map<String,Object> model) {
//       System.out.println(" ****** bind to Map ****** " + model);
//       System.out.println(model.get("firstName"));
//       System.out.println(model.get("lastName"));
//       return "RequestParam";
//   }
   
//  // Model
//  @RequestMapping(method=RequestMethod.POST)
//  public ModelAndView submit(Model model) {
//      System.out.println(" ****** bind to ModelAndView ****** " + model);
//      System.out.println(model.getAttribute("firstName")); // no getAttribute method for Model!
//      System.out.println(model.getAttribute("lastName"));
//      return "RequestParam";
//  }
	
//   // ModelAndView
//   @RequestMapping(method=RequestMethod.POST)
//   public ModelAndView submit(ModelAndView model) {
//       System.out.println(" ****** bind to ModelAndView ****** " + model);
//       System.out.println(model.getModel().get("firstName"));
//       System.out.println(model.getModel().get("lastName"));
//       model.setViewName("RequestParam");
//       return model;
//   }
   
//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//       System.out.println(" ****** bind to HttpServletRequest ****** ");
//       System.out.println(request.getParameter("firstName"));
//       System.out.println(request.getParameter("lastName"));
//       String firstName = WebUtils.findParameterValue(request, "firstName");
//       String lastName = WebUtils.findParameterValue(request, "lastName");
//       System.out.println(firstName);
//       System.out.println(lastName);
//       return "redirect:/requestparam";
//   }
	
	
    //***************************************************************
    //               web page -> Controller; data format convert
    //***************************************************************
	
	
    //***************************************************************
    //               web page -> Controller; data validation
    //***************************************************************
	
	
	
}
