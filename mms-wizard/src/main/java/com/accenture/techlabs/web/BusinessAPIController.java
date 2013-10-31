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
public class BusinessAPIController {

	/**
	 * 
	 */
	public BusinessAPIController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/businessapi", method = RequestMethod.POST)
	public String businessapi_post(ModelMap model) {
		return "businessapi";
	}
	
	@RequestMapping(value="/businessapi", method = RequestMethod.GET)
	public String businessapi_get(ModelMap model) {
		return "businessapi";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
