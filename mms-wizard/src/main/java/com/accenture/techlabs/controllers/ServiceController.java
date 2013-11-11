/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Project;
import com.accenture.techlabs.domain.Service;
import com.accenture.techlabs.forms.CapabilityFormData;

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
	}
	
	@RequestMapping(value="/service", method = RequestMethod.POST)
	public String service_post(@ModelAttribute("product") Product product, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		System.out.println("POST =========== SERVICE CONTROLLER===============");
		
		//STEP 1. Set the mandatory capabilities and optional capabilities to session.
		HttpSession session = request.getSession();
		Project project = (Project) session.getAttribute("project");
		Product productInSession = project.getProductList().get(0);
		List<Capability> optionalCaps = product.getOptionalCapabilityList();
		System.out.println("List Optional: " + optionalCaps);
		productInSession.setOptionalCapabilityList(optionalCaps); //test if this session data is persisted.
		//List<Capability> mandatory = productInSession.getOptionalCapabilityList();
		
		//STEP 2. Retrieve all services associated with mandatory capabilities.
		List<Capability> mandatoryCapListWithServices = new ArrayList<Capability>(); 
		List<Capability> mandatoryCaps = project.getProductList().get(0).getMandatoryCapabilityList();
		System.out.println("---------------------------------------------------------------mandatory");
		for(Capability c: mandatoryCaps){
			System.out.println("MandatoryCap: " + c.getUri());
			List<Service> relatedServices = getServicesForCapability(c.getUri());
			c.setServiceList(relatedServices);
			mandatoryCapListWithServices.add(c);
		}
		//model.addAttribute("mandatoryCapabilityList", mandatoryCapListWithServices);
	
		//STEP 3.Retrieve all services associated with each optional capability that was selected.
		System.out.println("-----------------------------------------------------------------optional");
		List<Capability> optionalCapListWithServices = new ArrayList<Capability>(); 
		if(optionalCaps != null){
			for(Capability c: optionalCaps){
				System.out.println("Cap: " + c.getUri());
				List<Service> relatedServices = getServicesForCapability(c.getUri());
				c.setServiceList(relatedServices);
				optionalCapListWithServices.add(c);
			}
			System.out.println("capWithserv: " + optionalCapListWithServices);
			//model.addAttribute("optionalCapabilityList", optionalCapListWithServices);
		}
		//-----testing
		product.setMandatoryCapabilityList(mandatoryCapListWithServices);
		product.setOptionalCapabilityList(optionalCapListWithServices);
		model.addAttribute("product", product);
		System.out.println("======================================================================== Done");
		return "service";
	}
	
	
	private List<Service> getServicesForCapability(String capability){
		List<Service> servicesList = new ArrayList<Service>();
		int i = Math.abs((new Random()).nextInt()%3) + 1;
		System.out.println("Generated i: " + i);
		System.out.println("...... for : " + capability + " -->" + i + "services...");
		for(int j=0; j<i; j++){
			Service s = new Service("cap:"+capability+"#"+(new Random()).nextInt());
			s.setName(s.getUri());
			servicesList.add(s);
		}
		System.out.println("Service list created: " + servicesList);
		return servicesList;
	}
	
	
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public String service_get(ModelMap model) {
		return "service";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}