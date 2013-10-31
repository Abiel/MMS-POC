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
public class ServiceProviderController {

	/**
	 * 
	 */
	public ServiceProviderController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/serviceprovider", method = RequestMethod.POST)
	public String provider_post(ModelMap model) {
		return "serviceprovider";
	}
	
	@RequestMapping(value="/serviceprovider", method = RequestMethod.GET)
	public String provider_get(ModelMap model) {
		return "serviceprovider";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
