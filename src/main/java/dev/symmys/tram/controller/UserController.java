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
	
	@GetMapping("/login/checkUser")
	public @ResponseBody String checkIfExists(HttpServletRequest request) {

		String email = request.getParameter("regEmail");
		String firstName = request.getParameter("regfName");
		String lastName = request.getParameter("reglName");	

		if(objLoginService.doesUserHaveAccount(email)){
			return "false";
		} 

		User objUser = new User();
		objUser.setEmail(email);
		objUser.setFirstName(firstName);
		objUser.setLastName(lastName);

		int count = objLoginService.registerUser(objUser);
		objUser = objLoginService.getUserByEmail(email);
		if(count > 0){
			request.getSession().setAttribute("loggedInUser", objUser);
			return "true";
		} else {
			return "Error While Processing Request";
		}
	}
}
