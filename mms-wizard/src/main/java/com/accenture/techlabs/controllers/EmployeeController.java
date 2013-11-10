/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Project;
import com.accenture.techlabs.forms.Department;
import com.accenture.techlabs.forms.Employee;
import com.accenture.techlabs.forms.Organization;
import com.accenture.techlabs.httpclient.SparqlClient;

/**
 * @author abiel.m.woldu
 *
 */
@Controller
public class EmployeeController {

	/**
	 * 
	 */
	public EmployeeController() {
	}
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String product_post(@ModelAttribute("organization") Organization organization, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
			System.out.println("=========== POST Employee CONTROLLER===============");
			//STEP 1. show me which employees are selected for each admin department.
			List<Department> adminDepartments = organization.getAdminDepartmentList();
			
			for(Department dept: adminDepartments){
				System.out.println("Admin Dept name::: " + dept.getName());
				List<Employee> employeeList = dept.getEmployeeList();
				if(employeeList != null){
					for(Employee emp: employeeList){
						System.out.println("Employee::"+ emp.getFirstName());
					}
				}else{
					System.out.println("\tnull admin dept");
				}
			}
			
			//STEP 2. show me which employees are selected for each employee department.
			List<Department> employeeDepartments = organization.getEmployeeDepartmentList();
			for(Department dept: employeeDepartments){
				System.out.println("Employee Dept name::: " + dept.getName());
				List<Employee> employeeList = dept.getEmployeeList();
				if(employeeList!=null){
					for(Employee emp: employeeList){
						System.out.println("Employee::"+ emp.getFirstName());
					}
				}else{
					System.out.println("\tnull employee dept");
				}
			}
			model.addAttribute("organization", organization);
			/*System.out.println("First Admin dept emp size: " + organization.getAdminDepartmentList().get(0).getEmployeeList().size());
			System.out.println("First Emplo dept emp size: " + organization.getEmployeeDepartmentList().get(0).getEmployeeList().size());*/
		return "employee";
	}
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		try {
			String products = SparqlClient.getProducts();
			List<Product> productList;
			productList = toProductList(products);
			model.addAttribute("productList", productList);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "employee";
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
