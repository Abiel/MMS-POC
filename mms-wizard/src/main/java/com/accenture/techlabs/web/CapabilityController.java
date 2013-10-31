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
	public String component_post(ModelMap model) {
		try {
			String capComApiResponse = SparqlClient.getCapabilityComponentAPI();
			List<Capability> allCapability = toCapabilityList(capComApiResponse);
			model.addAttribute("capabilityList", allCapability);
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
			capabilityDomainObj.setName(cap.getString("value"));
			if(!allCapabilities.contains(capabilityDomainObj))
				allCapabilities.add(capabilityDomainObj);
		}
		return allCapabilities;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
