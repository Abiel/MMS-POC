/**
 * 
 */
package com.accenture.techlabs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author abiel.m.woldu
 *
 */
@Controller
public class ServiceController {

	/**
	 * 
	 */
	public ServiceController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/service", method = RequestMethod.POST)
	public String service_post(ModelMap model) {
		System.out.println("... controller for POST service caalled");
		return "service";
	}
	
	
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public String service_get(ModelMap model) {
		System.out.println("... controller for GET service caalled");
		return "service";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
