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
import com.accenture.techlabs.domain.Capability;
import com.accenture.techlabs.domain.Service;

/**
 * @author abiel.m.woldu
 *
 */
public class ServiceSparqlClient {

	public ServiceSparqlClient() {
	}
	
	public static List<Capability> getServicesForCapabilities(List<Capability> capabilityList){
		try {
			String allServices = queryGetAllServices();
			capabilityList = processJSON(allServices, capabilityList);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return capabilityList;
	}
	
	public static String queryGetAllServices(){
		WebClient client = WebClient.create(Constants.URIs.SERVICES_API);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
	}
	
	public static List<Capability> processJSON(String response, List<Capability> capabilityList) throws JSONException{
		if(capabilityList == null) return null;
		JSONObject resp = new JSONObject(response);
		if(resp.has("results")){
			JSONObject results = resp.getJSONObject("results");
			if(results.has("bindings")){
				JSONArray bindings = results.getJSONArray("bindings");
				for(Capability c: capabilityList){
					for(int i=0; i<bindings.length(); i++){
						JSONObject current = bindings.getJSONObject(i);
						String capability = null;
						if(current.has("subcapability")){
							JSONObject subcapability = current.getJSONObject("subcapability");
							if(subcapability.has("value")){
								capability = subcapability.getString("value");
							}
						}
						if(c.getUri().equals(capability)){
							Service serviceObject = new Service();
							//only fetch serviceName if capability matches...
							String serviceName = null;
							if(current.has("service")){
								JSONObject service = current.getJSONObject("service");
								if(service.has("value")){
									serviceName = service.getString("value");
									System.out.println("[[capability]]:" + c.getUri());
									System.out.println("\t\t[[service]]:" + serviceName);
								}
							}
							serviceObject.setUri(serviceName);
							serviceObject.setName(getName(serviceName));
							if(c.getServiceList()==null)
								c.setServiceList(new ArrayList<Service>());    //if service list was null then initialize it, else add it.
							c.getServiceList().add(serviceObject);
						}
					}
				}
			}
		}
		return capabilityList;
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
