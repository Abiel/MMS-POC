/**
 * 
 */
package com.accenture.techlabs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.httpclient.SparqlClient;

/**
 * @author abiel.m.woldu
 *
 */
@Controller
public class ProductController {

	/**
	 * 
	 */
	public ProductController() {
	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		System.out.println("... controller for GET product caalled");
		String products = SparqlClient.getProducts();
		System.out.println("Controller got products...");
		model.addAttribute("productList", products);
		return "product";
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public String product_post(ModelMap model) {
		System.out.println("... controller for POST product caalled");
		String products = SparqlClient.getProducts();
		System.out.println("Controller got products...");
		model.addAttribute("productList", products);
		return "product";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
