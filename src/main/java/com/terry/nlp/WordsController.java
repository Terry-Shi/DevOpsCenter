package com.terry.nlp;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/words")
public class WordsController {

	//private ContactRepository contactRepo;
//
//	@Autowired
//	public ContactController(ContactRepository contactRepo) {
//		this.contactRepo = contactRepo;
//	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String, Object> model) {
	    Words words = new Words();
	    words.setInputtext("my input text");
	    words.setResult("my result");
	    model.put("words", words);
		return "words";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String submit(Words words, Map<String, Object> model) {
	    words.setResult("changed");
	    model.put("words", words);
		return "words";
	}
}