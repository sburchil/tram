package dev.symmys.tram.controller;

import java.util.Enumeration;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/login/checkUser")
	public @ResponseBody String checkIfExists(HttpServletRequest request) {

		JSONObject jsonObj = null;
		jsonObj = new JSONObject(request.getParameterMap());
		
		System.out.println(jsonObj.toString());
		return "hello";
	}
}
