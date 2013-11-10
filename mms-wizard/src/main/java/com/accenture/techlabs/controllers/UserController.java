/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.techlabs.constants.Constants;
import com.accenture.techlabs.entities.User;
import com.accenture.techlabs.httpclient.SparqlClient;
import com.accenture.techlabs.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model, @RequestParam(value="failed", required=false) boolean loginFailed) {
		if(loginFailed)
			model.addAttribute("error", "Login Failed");
		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		return "welcome";
	}

	@RequestMapping("/userhome")
	public String userhome(Model model) 
	{
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "userhome";
	}
	
	@RequestMapping("/admin/adminhome")
	public String adminhome(Model model) 
	{
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "admin/adminhome";
	}
		
}
