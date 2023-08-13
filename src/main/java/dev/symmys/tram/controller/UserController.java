package dev.symmys.tram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/login")
	public ModelAndView userLogin(HttpServletRequest request, ModelAndView model) {
		
		model.setViewName("login");
		return model;
	}
}
