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
import com.accenture.techlabs.domain.Adapter;
import com.accenture.techlabs.domain.AppComponent;
import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Product;
import com.accenture.techlabs.domain.Service;

/**
 * @author abiel.m.woldu
 *
 */
public class AdapterSparqlClient {

	public AdapterSparqlClient() {
	}
	
	public static Product getAdaptersForAllServices(Product product){
		try {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~Adapter data population~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			//STEP 1. get all components from SPARQL API.
			String allComponents = queryGetAllAdapters();
			
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
	
	public static String queryGetAllAdapters(){
		WebClient client = WebClient.create(Constants.URIs.ADAPTER_API);
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
							JSONObject serviceName = current.getJSONObject("service");
							if(serviceName.has("value")){
								service = serviceName.getString("value");
							}
						}
						//only fetch Adapter from JSON if service matches...
						if(s.getUri().equals(service)){
							Adapter newAdapter = new Adapter();
							String adapterName = null;
							if(current.has("adapter")){
								JSONObject adapter = current.getJSONObject("adapter");
								if(adapter.has("value")){
									adapterName = adapter.getString("value");
									System.out.println("[[service]]:" + s.getUri());
									System.out.println("\t\t[[adapter]]:" + adapterName);
								}
							}
							newAdapter.setUri(adapterName);
							newAdapter.setName(getName(adapterName));
							if(s.getAdapterList()==null)
								s.setAdapterList(new ArrayList<Adapter>());    //if Adapter list was null then initialize it, else add it.
							s.getAdapterList().add(newAdapter);
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
