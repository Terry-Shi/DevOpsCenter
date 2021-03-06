package com.terry.example01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.terry.contacts.Contact;

@Controller
@RequestMapping("/requestparam")
public class RequestParamController {

    //***************************************************************
    //               Server -> Client
    //***************************************************************
	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
	    model.put("firstName", "set param firstname");
	    model.put("lastName", "set param lastname");
		return "RequestParam";
	}
	
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
    
//    @RequestMapping(method = RequestMethod.GET)
//    public String home(@ModelAttribute("contact") Contact contact) {
//        System.out.println(contact);
//        contact.setFirstName("set param firstname in @ModelAttribute");
//        contact.setLastName("set lastname in @ModelAttribute");
//        return "RequestParam";
//    }

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
    //               Client -> Server
    //***************************************************************
	@RequestMapping(method=RequestMethod.POST)
    public String submit(
            @RequestBody String req 
            ) {
        System.out.println(" ****** Bind to Variable by @RequestBody - OK ****** ");
        System.out.println(req);
        // 如果form中有两个数据
        //        mvm.add("firstName", "firstName from UT code");
        //        mvm.add("lastName", "lastName from UT code");
        // 输出将会是
        // firstName=firstName+from+UT+code&lastName=lastName+from+UT+code
        return "RequestParam"; 
    }
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String submit(
//	        @RequestParam("firstName") String firstName, 
//	        @RequestParam("lastName") String lastName) {
//	    System.out.println(" ****** Bind to Variable by @RequestParam - OK ****** ");
//	    System.out.println(firstName);
//	    System.out.println(lastName);
//		return "RequestParam"; 
//	}
	
//   @RequestMapping(method=RequestMethod.POST)
//    public String submit(Contact contact) {
//	    System.out.println(" ****** Bind to POJO ****** - OK " + contact);
//        System.out.println(contact.getFirstName());
//        System.out.println(contact.getLastName());
//        return "RequestParam";
//    }

//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(Map<String,Object> map) {
//       System.out.println(" ****** Bind to Map ****** - NG " + map);
//       System.out.println(map.get("firstName"));
//       System.out.println(map.get("lastName"));
//       return "RequestParam";
//   }
   
//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(Model model) {
//        System.out.println(" ****** Bind to ModelAndView ******  - NG " + model.asMap());
//        System.out.println(model.asMap().get("firstName"));
//        System.out.println(model.asMap().get("lastName"));
//        return "RequestParam";
//    }
//	
//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(ModelMap modelMap) {
//        System.out.println(" ****** Bind to ModelMap ******  - NG " + modelMap);
//        System.out.println(modelMap.get("firstName"));
//        System.out.println(modelMap.get("lastName"));
//        return "RequestParam";
//    }
	
//   // ModelAndView
//   @RequestMapping(method=RequestMethod.POST)
//   public ModelAndView submit(ModelAndView model) {
//       System.out.println(" ****** Bind to ModelAndView ****** - NG " + model);
//       System.out.println(model.getModel().get("firstName"));
//       System.out.println(model.getModel().get("lastName"));
//       model.setViewName("RequestParam");
//       return model;
//   }
   
//   @RequestMapping(method=RequestMethod.POST)
//   public String submit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//       System.out.println(" ****** Bind to HttpServletRequest ****** - OK");
//       System.out.println(request.getParameter("firstName"));
//       System.out.println(request.getParameter("lastName"));
//       String firstName = WebUtils.findParameterValue(request, "firstName");
//       String lastName = WebUtils.findParameterValue(request, "lastName");
//       System.out.println(firstName);
//       System.out.println(lastName);
//       return "redirect:/requestparam";
//   }
	
	
	//**********************Restful*********************************
	//in order to produce a JSON response with UTF-8 encoding, "application/json; charset=UTF-8" should be used.
	// TODO: "produces" 是否同时限制了Request的类型，也限定了Response的类型？
    @RequestMapping(value = "restful", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public @ResponseBody Contact restFulPost(@RequestBody Contact contact, HttpServletRequest request) {
        
        System.out.println("************* RESTful Post ***********");
        String contentType = request.getContentType();   
        System.out.println("************* contentType ***********:" + contentType);
        System.out.println(contact);
        contact.setEmailAddress("a@b.com");
        return contact;
    }
	
    //***************************************************************
    //               web page -> Controller; data format convert
    //***************************************************************
	
	
    //***************************************************************
    //               web page -> Controller; data validation
    //***************************************************************
	
	
	
}
