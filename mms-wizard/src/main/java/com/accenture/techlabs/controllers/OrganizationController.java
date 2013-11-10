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
import com.accenture.techlabs.forms.Department;
import com.accenture.techlabs.forms.Organization;
import com.accenture.techlabs.httpclient.SparqlClient;

/**
 * @author abiel.m.woldu
 *
 */
@Controller
public class OrganizationController {

	/**
	 * 
	 */
	public OrganizationController() {
	}
	
	
	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	public String product_post(ModelMap model, HttpServletRequest request) {
	
			System.out.println("===========POST Organization CONTROLLER===============");
			HttpSession session = request.getSession();
			
			//use API to retrieve department data.
			Organization organization = new Organization();
			organization.setName("hello");
			organization.setAdminDepartmentList(retrieveAdminDepartments());
			organization.setEmployeeDepartmentList(retrieveEmployeeDepartments());
			model.addAttribute("organization", organization);
			
		return "organization";
	}
	
	
	@RequestMapping(value = "/organization", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		//try {
			String products = SparqlClient.getProducts();
			List<Product> productList;
			productList = null; //toProductList(products);
			model.addAttribute("productList", productList);
			
		/*} catch (JSONException e) {
			e.printStackTrace();
		}*/
		return "organization";
	}
	
	public List<Department> retrieveAdminDepartments(){
		Department d0 = new Department(0);
		d0.setId(0);
		d0.setName("Admin");
		Department d1 = new Department(1);
		d1.setId(1);
		d1.setName("Registry");
		/*Department d2 = new Department(2);
		d2.setName("Management");*/
		
		List<Department> adminDeptList = new ArrayList<Department>();
		adminDeptList.add(d0);
		adminDeptList.add(d1);
		//adminDeptList.add(d2);
		
		return adminDeptList;
	}
	
	public List<Department> retrieveEmployeeDepartments(){
		Department e0 = new Department(0);
		e0.setId(3);
		e0.setName("EmployeeFitness");
		Department e1 = new Department(1);
		e1.setId(4);
		e1.setName("EmployeeRecreation");
		/*Department e2 = new Department(2);
		e2.setName("EmployeeHealth");*/
		
		List<Department> employeeDeptList = new ArrayList<Department>();
		employeeDeptList.add(e0);
		employeeDeptList.add(e1);
		//employeeDeptList.add(e2);
		
		return employeeDeptList;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
