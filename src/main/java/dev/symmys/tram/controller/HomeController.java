package dev.symmys.tram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView returnHome(ModelAndView modelAndView) {
	    String message = "Hello Symon";
	    modelAndView.addObject("message", message);
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	
//	@GetMapping("/fragments")
//	public String frags() {
//	    return "/parts/header";
//	}
}
