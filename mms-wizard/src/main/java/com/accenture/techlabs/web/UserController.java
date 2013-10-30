/**
 * 
 */
package com.accenture.techlabs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.entities.User;
import com.accenture.techlabs.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		System.out.println("... controller for weelcome.");
		return "welcome";
	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("... controller for product caalled");
		return "product";
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public String product_post(ModelMap model) {
		System.out.println("... controller for product caalled");
		return "product";
	}
	
	@RequestMapping(value="/capability", method = RequestMethod.POST)
	public String component_post(ModelMap model) {
		System.out.println("... controller for capability caalled");
		return "capability";
	}
	
	@RequestMapping(value="/service", method = RequestMethod.POST)
	public String service_post(ModelMap model) {
		System.out.println("... controller for service caalled");
		return "service";
	}
	
	@RequestMapping(value="/serviceprovider", method = RequestMethod.POST)
	public String provider_post(ModelMap model) {
		System.out.println("... controller for provider caalled");
		return "serviceprovider";
	}
	
	@RequestMapping(value="/businessapi", method = RequestMethod.POST)
	public String businessapi_post(ModelMap model) {
		System.out.println("... controller for provider caalled");
		return "businessapi";
	}

	@RequestMapping("/userhome")
	public String userhome(Model model) 
	{
		System.out.println("... controller for /userhome");
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "userhome";
	}
	
	@RequestMapping("/admin/adminhome")
	public String adminhome(Model model) 
	{
		System.out.println("... controller of /admin/adminhome");
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "admin/adminhome";
	}
		
}
