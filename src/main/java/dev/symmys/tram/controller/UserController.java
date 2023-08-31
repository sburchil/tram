package dev.symmys.tram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.symmys.tram.entity.User;
import dev.symmys.tram.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	LoginService objLoginService;

	@GetMapping("/login")
	public @ResponseBody String userLogin(HttpServletRequest request) {
		return "model";
	}
	
	@GetMapping("/checkifexists")
	public @ResponseBody String checkIfExists(HttpServletRequest request) {

		String email = request.getParameter("regEmail");
		String userName = request.getParameter("loginUsername");

		if(email != null && !email.isEmpty()) {
			User user = objLoginService.getUserByEmail(userName);
			return (user != null) ? "true" : "false";
		} else if(userName != null && !userName.isEmpty()) {
			User user = objLoginService.getUserByUsername(userName);
			return (user != null) ? "true" : "false";
		} else {
			return "false";
		}
	}
}
