/**
 * 
 */
package com.accenture.techlabs.httpclient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.accenture.techlabs.constants.Constants;
import com.accenture.techlabs.domain.AppComponent;
import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Service;

/**
 * @author abiel.m.woldu
 *
 */
public class AppComponentSparqlClient {

	public AppComponentSparqlClient() {
	}
	
	public static Product getAppComponentsForAllServices(Product product){
		try {
			//STEP 1. get all components from SPARQL API.
			String allComponents = queryGetAllAppComponents();
			
			//STEP 2. Populate components List to services under mandatory capabilities.
			//services from mandatory capabilities
			List<Capability> mandatoryCapabilities = product.getMandatoryCapabilityList();
			if(mandatoryCapabilities != null){
				for(Capability c: mandatoryCapabilities){
					processJSON(allComponents, c.getServiceList());
				}
			}	
			
			//STEP 3. Populate components List to services under optional capabilities.
			//services from optional capabilities
			List<Capability> optionalCapabilities = product.getOptionalCapabilityList();
			if(optionalCapabilities != null){
				for(Capability c: optionalCapabilities){
					processJSON(allComponents, c.getServiceList());
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public static String queryGetAllAppComponents(){
		WebClient client = WebClient.create(Constants.URIs.APP_COMPONENT_API);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
	}
	
	public static List<Service> processJSON(String response, List<Service> serviceList) throws JSONException{
		if(serviceList == null) return null;
		JSONObject resp = new JSONObject(response);
		if(resp.has("results")){
			JSONObject results = resp.getJSONObject("results");
			if(results.has("bindings")){
				JSONArray bindings = results.getJSONArray("bindings");
				for(Service s: serviceList){
					for(int i=0; i<bindings.length(); i++){
						JSONObject current = bindings.getJSONObject(i);
						String service = null;
						if(current.has("service")){
							JSONObject subcapability = current.getJSONObject("service");
							if(subcapability.has("value")){
								service = subcapability.getString("value");
							}
						}
						if(s.getUri().equals(service)){
							AppComponent appComponent = new AppComponent();
							//only fetch componentName if service matches...
							String componentName = null;
							if(current.has("component")){
								JSONObject component = current.getJSONObject("component");
								if(component.has("value")){
									componentName = component.getString("value");
									System.out.println("[[service]]:" + s.getUri());
									System.out.println("\t\t[[component]]:" + componentName);
								}
							}
							appComponent.setUri(componentName);
							appComponent.setName(getName(componentName));
							if(s.getAppComponentList()==null)
								s.setAppComponentList(new ArrayList<AppComponent>());    //if component list was null then initialize it, else add it.
							s.getAppComponentList().add(appComponent);
						}
					}
				}
			}
		}
		return serviceList;
	}
	
	public static String getName(String uri){
		if(uri != null){
			String parts[] = uri.split("#") ;
			if(parts.length >= 2) return parts[1];
		}
		return uri;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
