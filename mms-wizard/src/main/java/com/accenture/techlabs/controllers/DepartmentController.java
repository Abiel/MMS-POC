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
public class DepartmentController {

	/**
	 * 
	 */
	public DepartmentController() {
	}
	
	
	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public String product_post(@ModelAttribute("organization") Organization organization, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {

			System.out.println("=========== PRODUCT CONTROLLER===============");
			//STEP 1. for each selected department retrieve the employee list for display.
			List<Department> adminDepartments = organization.getAdminDepartmentList();
			for(Department dept: adminDepartments){
				System.out.println("Admin Dept: " + dept.getName());
				List<Employee> employeeList = getEmployeeListAPI(dept.getName());
				dept.setEmployeeList(employeeList);
			}
			
			List<Department> employeeDepartments = organization.getEmployeeDepartmentList();
			for(Department dept: employeeDepartments){
				System.out.println("Employee Dept: " + dept.getName());
				List<Employee> employeeList = getEmployeeListAPI(dept.getName());
				dept.setEmployeeList(employeeList);
			}
			//STEP 2. now departments are populated with employees. Attach department lists to organization.
			model.addAttribute("organization", organization);
			System.out.println("First Admin dept emp size: " + organization.getAdminDepartmentList().get(0).getEmployeeList().size());
			System.out.println("First Emplo dept emp size: " + organization.getEmployeeDepartmentList().get(0).getEmployeeList().size());
		return "department";
	}
	
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String product_get(ModelMap model) {
		System.out.println("============GET Dept Controller==============");
		return "department";
	}
	
	
	private List<Employee> getEmployeeListAPI(String departmentName) {
		Employee e1,e2;
		List<Employee> employeeList = new ArrayList<Employee>();
		if(departmentName.equals("Admin")){
			e1=new Employee("Rahel");
			e2=new Employee("Feven");
			employeeList.add(e1);
			employeeList.add(e2);
		}
		if(departmentName.equals("Registry")){
			e1=new Employee("Hala");
			e2=new Employee("Ere");
			employeeList.add(e1);
			employeeList.add(e2);
		}
		if(departmentName.equals("EmployeeFitness")){
			e1=new Employee("John");
			e2=new Employee("Bibo");
			employeeList.add(e1);
			employeeList.add(e2);
		}
		if(departmentName.equals("EmployeeRecreation")){
			e1=new Employee("Abiti");
			e2=new Employee("Doggy");
			employeeList.add(e1);
			employeeList.add(e2);
		}
		return employeeList;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
