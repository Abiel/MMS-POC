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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Project;
import com.accenture.techlabs.httpclient.SparqlClient;

/**
 * @author abiel.m.woldu
 * 
 */
@Controller
public class CapabilityController {

	/**
	 * 
	 */
	public CapabilityController() {
	}

	@RequestMapping(value = "/capability", method = RequestMethod.POST)
	public String component_post(@ModelAttribute("project") Project project, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, ModelMap model) {
		try {
			System.out.println("=========== CAPABILITY CONTROLLER ===============");
			
			//At least one product has to be selected in the project. Change this to javascript form validation.
			if(project.getProductList() == null){
				return "redirect:product.htm";
			}
			
			System.out.println("Project Selected: " + project.getProjectName());
			System.out.println("products::: " + project.getProductList().size());
			System.out.println("product 1: " + project.getProductList().get(0).getName() + " || " + project.getProductList().get(0).getUri());
			
			//STEP 1. For each product selected, make sparql http call and retrieve capabilities.
			String capComApiResponse = SparqlClient.getCapabilityComponentAPI();
			List<Capability> allCapability = toCapabilityList(capComApiResponse);
			List<Capability> mandatoryCapabilityList = SparqlClient.getMandatoryCapabilities();
			List<Capability> optionalCapabilityList = SparqlClient.getOptionalCapabilities();
			System.out.println("SETTING OPTIONAL CAPABILITIES...");
			//project.getProductList().get(0).setOptionalCapabilityList(allCapability);
			System.out.println("SETTING MANDATORY CAPABILITIES...");
			//project.getProductList().get(0).setMandatoryCapabilityList(allCapability);
			
			//.... may be just for display create a Product instance that has mandatory and optional capabilities...
			// or should u change the variable in session?
			project.getProductList().get(0).setMandatoryCapabilityList(mandatoryCapabilityList);
			project.getProductList().get(0).setOptionalCapabilityList(optionalCapabilityList);
			/*model.addAttribute("mandatoryCapabilityList", allCapability); //JUST FOR DISPLAY. In ServiceController this comes as null. coz it's inactive.
			model.addAttribute("optionalCapabilityList", allCapability);*/
			HttpSession session = request.getSession();
			session.setAttribute("project", project);
			session.setAttribute("productName", project.getProductList().get(0).getUri());
			model.addAttribute("product", project.getProductList().get(0));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "capability";
	}

	@RequestMapping(value = "/capability", method = RequestMethod.GET)
	public String component_get(ModelMap model) {
		return "capability";
	}

	

	private List<Capability> toCapabilityList(String capabilityList)
			throws JSONException {
		List<Capability> allCapabilities = new ArrayList<Capability>();
		JSONObject allData = new JSONObject(capabilityList);
		JSONObject result = allData.getJSONObject("results");
		JSONArray bindings = result.getJSONArray("bindings");
		for (int i = 0; i < bindings.length(); i++) {
			JSONObject current = bindings.getJSONObject(i);
			JSONObject cap = current.getJSONObject("cap");
			Capability capabilityDomainObj = new Capability();
			capabilityDomainObj.setUri(cap.getString("value"));
			capabilityDomainObj.setName(cleanUpCapability(cap.getString("value")));
			if(!allCapabilities.contains(capabilityDomainObj))
				allCapabilities.add(capabilityDomainObj);
		}
		return allCapabilities;
	}
	
	private String cleanUpCapability(String capability){
		if(capability != null){
			if(capability.contains("http://metadatamodel.accenture.com#")){
				String parts[] = capability.split("http://metadatamodel.accenture.com#");
				return (parts.length>=1)? parts[1]:capability;
			}		
		}
		return capability;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
