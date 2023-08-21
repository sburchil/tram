package dev.symmys.tram.controller;

import java.sql.SQLException;
import java.util.Enumeration;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

		String email = request.getParameter("email");
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");	

		boolean exists = objLoginService.doesUserHaveAccount(email);
		System.out.println(exists);
		JSONObject jsonObj = new JSONObject(request.getParameterMap());

		System.out.println(jsonObj.toString());
		return "hello";
	}
}
