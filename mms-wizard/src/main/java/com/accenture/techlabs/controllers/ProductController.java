/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Project;
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
	
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product_post(ModelMap model, HttpServletRequest request) {
		System.out.println("+++++=========== PRODUCT CONTROLLER===============");
		try {
			String products = SparqlClient.getProducts();
			List<Product> productList;
			productList = toProductList(products);
			model.addAttribute("productList", productList);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "product";
	}
	
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		System.out.println("GET=========== PRODUCT CONTROLLER===============");
		try {
			String products = SparqlClient.getProducts();
			List<Product> productList;
			productList = toProductList(products);
			model.addAttribute("productList", productList);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "product";
	}
	
	
	private List<Product> toProductList(String productList) throws JSONException {
		List<Product> allProducts = new ArrayList<Product>();
		JSONObject allData = new JSONObject(productList);
		JSONObject result = allData.getJSONObject("results");
		JSONArray bindings = result.getJSONArray("bindings");
		for (int i = 0; i < bindings.length(); i++) {
			JSONObject current = bindings.getJSONObject(i);
			JSONObject product = current.getJSONObject("product");
			Product productDomainObj = new Product(product.getString("value"));
			String productRDFuri = product.getString("value");
			String parts[] = productRDFuri.split("#");
			productDomainObj.setName(parts[1]);
			if(!allProducts.contains(productDomainObj))
				allProducts.add(productDomainObj);
		}
		Product p = new Product();
		p.setName("hello");
		allProducts.add(p);
		
		return allProducts;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
