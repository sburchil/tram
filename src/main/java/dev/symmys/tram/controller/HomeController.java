package dev.symmys.tram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView returnHome(HttpServletRequest request, ModelAndView modelAndView) {
		if(request.getSession().getAttribute("loggedInUser") == null) {
			request.getSession().setAttribute("loggedInUser", null);
		}
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	
}
