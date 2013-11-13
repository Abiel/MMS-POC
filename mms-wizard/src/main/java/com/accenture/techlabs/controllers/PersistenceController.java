/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.dao.ProjectDao;
import com.accenture.techlabs.domain.Adapter;
import com.accenture.techlabs.domain.AppComponent;
import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Project;
import com.accenture.techlabs.domain.Service;
import com.accenture.techlabs.httpclient.AppComponentSparqlClient;

/**
 * @author abiel.m.woldu
 * Why this class? 
 * As the user finishes selecting Product->Capability->Service->AppComponent/Adapter; this controller persists all this data to database.
 */
@Controller
public class PersistenceController {
	@Autowired
	ProjectDao projectDao;
	
	/**
	 * 
	 */
	public PersistenceController() {
	}
	
	@RequestMapping(value="/persistence", method = RequestMethod.POST)
	public String persist_post(@ModelAttribute("product") Product product, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		System.out.println("POST===============PERSIST CONTROLLER-===============");
		
		//STEP 1. Remove mandatory capabilities that have no services.
		List<Capability> mandatoryCapsList = product.getMandatoryCapabilityList();
		System.out.println("Printing Mandatory List...");
		List<Capability> cleanedMandatoryCapabilities = cleanUpCapabilityList(mandatoryCapsList);
		product.setMandatoryCapabilityList(cleanedMandatoryCapabilities);
		printCapabilityList(product.getMandatoryCapabilityList());
		
		//STEP 2. Remove optional capabilities that have no services.
		List<Capability> optionalCapsList = product.getOptionalCapabilityList();
		System.out.println("Printing optional List...");
		List<Capability> cleanedOptionalCapabilities = cleanUpCapabilityList(optionalCapsList);
		product.setOptionalCapabilityList(cleanedOptionalCapabilities);
		printCapabilityList(product.getOptionalCapabilityList());
		//System.out.println("size optional cap: " + product.getOptionalCapabilityList().size());
		
		//STEP 3. Inject the cleaned up product in to the project that was in session.
		HttpSession session = request.getSession();
		Project project = (Project) session.getAttribute("project");
		System.out.println("Project:: "+ project.toString());
		List<Product> newProductList = new ArrayList<Product>();
		newProductList.add(product);
		project.setProductList(newProductList);
		project.getProductList().get(0).setUri((String) session.getAttribute("productName"));
		
		//STEP 4. Persist the data to a data repository.
		try {
		projectDao.insertProjectAndAllRelatedData(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//STEP 5. Display the data for the user to see in persist.htm
		model.addAttribute("projectName", project.getProjectName());
		model.addAttribute("product", product);
		return "persistence";
	}
	
	@RequestMapping(value="/persistence", method = RequestMethod.GET)
	public String persist_get(@ModelAttribute("project") Project project, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		System.out.println("GET===============PERSIST CONTROLLER-===============");
		return "persistence";
	}
	
	/**
	 * Removes capabilities with null services.
	 * @param capabilityList
	 */
	public List<Capability> cleanUpCapabilityList(List<Capability> capabilityList){
		if(capabilityList==null) return null; 
		List<Capability> newCapabilityList = new ArrayList<Capability>();
		for(Capability c: capabilityList){
			if(c.getServiceList() != null)
				newCapabilityList.add(c);
		}
		return newCapabilityList;
	}
	
	private void printCapabilityList(List<Capability> capabilityList){
		if(capabilityList!= null){
			for(Capability c: capabilityList){
				System.out.println("\tCap::" + c.getUri() );
				printServices(c);
			}
		}else{
			System.out.println("\tCap is null.");
		}
	}

	private void printServices(Capability cap){
			List<Service> services = cap.getServiceList();
			if(services != null){
				for(Service ser : services){
					System.out.println("\t\tSer::" + ser.getUri());
					printAppComponents(ser);
					printAdapters(ser);
				}	
			}else{
				System.out.println("\t\tSer is null.");
			}
	}
	
	private void printAppComponents(Service service){
		List<AppComponent> appComponentList = service.getAppComponentList();
		if(appComponentList!=null){
			for(AppComponent appComp: appComponentList){
				System.out.println("\t\t\tAppComp::" + appComp.getUri());
			}
		}
	}
	
	private void printAdapters(Service service){
		List<Adapter> adapterList = service.getAdapterList();
		if(adapterList != null){
			for(Adapter adapter: adapterList){
				System.out.println("\t\t\tAdapter::" + adapter.getUri());
			}
		}
	}
	
	
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
