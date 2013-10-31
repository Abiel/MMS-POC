/**
 * 
 */
package com.accenture.techlabs.web;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
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
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		try {
			System.out.println("... controller for GET product caalled");
			String products = SparqlClient.getProducts();
			System.out.println("Controller got products...");
			List<Product> productList;
			productList = toProductList(products);
			System.out.println(".... this is plist:" + productList);
			model.addAttribute("productList", productList);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "product";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product_post(ModelMap model) {
		try {
			System.out.println("... controller for POST product caalled");
			String products = SparqlClient.getProducts();
			List<Product> productList;
			System.out.println("...calling to product list...");
			productList = toProductList(products);
			System.out.println(".... this is plist:" + productList);
			System.out.println("Controller got products...");
			model.addAttribute("productList", productList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "product";
	}
	
	
	
	private List<Product> toProductList(String productList) throws JSONException {
		System.out.println("Processing productList: " + productList);
		List<Product> allProducts = new ArrayList<Product>();
		JSONObject allData = new JSONObject(productList);
		JSONObject result = allData.getJSONObject("results");
		JSONArray bindings = result.getJSONArray("bindings");
		for (int i = 0; i < bindings.length(); i++) {
			JSONObject current = bindings.getJSONObject(i);
			JSONObject product = current.getJSONObject("product");
			Product productDomainObj = new Product();
			productDomainObj.setName(product.getString("value"));
			System.out.println("Set: " + productDomainObj.getName());
			if(!allProducts.contains(productDomainObj))
				allProducts.add(productDomainObj);
		}
		System.out.println("Size: " + allProducts.size());
		System.out.println(allProducts);
		return allProducts;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
