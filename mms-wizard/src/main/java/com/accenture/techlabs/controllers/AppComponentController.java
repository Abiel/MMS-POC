/**
 * 
 */
package com.accenture.techlabs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * @author abiel.m.woldu
 *
 */
@Controller
public class AppComponentController {

	/**
	 * 
	 */
	public AppComponentController() {
	}
	
	@RequestMapping(value="/appcomponent", method = RequestMethod.POST)
	public String businessapi_post(@ModelAttribute("product") Product product, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		System.out.println("POST===============APP COMPONENT-===============");
		System.out.println("size mandatory cap: " + product.getMandatoryCapabilityList().size());
		List<Capability> mandatoryCapsList = product.getMandatoryCapabilityList();
		System.out.println("Printing Mandatory List...");
		printCapabilityList(mandatoryCapsList);
		
		List<Capability> optionalCapsList = product.getOptionalCapabilityList();
		System.out.println("Printing optional List...");
		printCapabilityList(optionalCapsList);
		System.out.println("size optional cap: " + product.getOptionalCapabilityList().size());
		return "appcomponent";
	}
	
	@RequestMapping(value="/appcomponent", method = RequestMethod.GET)
	public String businessapi_get(@ModelAttribute("project") Project project, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		System.out.println("GET===============APP COMPONENT-===============");
		return "appcomponent";
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
				}	
			}else{
				System.out.println("\t\tSer is null.");
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
