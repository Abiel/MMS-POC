/**
 * 
 */
package com.accenture.techlabs.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.accenture.techlabs.constants.Constants;
import com.accenture.techlabs.domain.Capability;

/**
 * @author abiel.m.woldu
 *
 */
public class SparqlClient {

	/**
	 * 
	 */
	public SparqlClient() {
	}
	
	public Response getAllProducts(){
		return null;
	}
	
	public static String getProducts(){
		WebClient client = WebClient.create(Constants.URIs.PRODUCTS);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
	}
	
	public static List<Capability> getMandatoryCapabilities(){
		String allCapabilities = getAllCapabilities();
		List<Capability> mandatoryCapabilities = new ArrayList<Capability>();
		try {
			mandatoryCapabilities = processCapabilities(allCapabilities, "Mandatory");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return mandatoryCapabilities;
	}
	
	public static List<Capability> getOptionalCapabilities(){
		String allCapabilities = getAllCapabilities();
		List<Capability> optionalCapabilities = new ArrayList<Capability>();
		try {
			optionalCapabilities = processCapabilities(allCapabilities, "Optional");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return optionalCapabilities;
	}
	
	
	public static String getAllCapabilities(){
		WebClient client = WebClient.create(Constants.URIs.CAPABILITY_API);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
	}
	
	public static List<Capability> processCapabilities(String allCapabilities, String capabilityType) throws JSONException{
		List<Capability> filteredCapability = new ArrayList<Capability>();
		JSONObject response = new JSONObject(allCapabilities);
		if(response.has("results")){
			JSONObject results = response.getJSONObject("results");
			if(results.has("bindings")){
				JSONArray bindings = results.getJSONArray("bindings");
				for(int i=0; i<bindings.length(); i++){
					JSONObject current = bindings.getJSONObject(i);
					if(current.has("type")){
						JSONObject type=current.getJSONObject("type");
						if(type.has("value")){
							String value = type.getString("value");
							if(capabilityType.equals(value)){
								Capability capability = new Capability();
								String uri = null;
								if(current.has("capability")){
									JSONObject finalCapability = current.getJSONObject("capability");
									uri = finalCapability.getString("value");
								}
								capability.setName(getName(uri));
								capability.setUri(uri);
								filteredCapability.add(capability);
							}
						}
					}
				}
			}
		}
		return filteredCapability;
	}
	
	public static String getName(String uri){
		if(uri != null){
			String parts[] = uri.split("#") ;
			if(parts.length >= 2) return parts[1];
		}
		return uri;
	}
	
	public static String getCapabilityComponentAPI(){
		WebClient client = WebClient.create(Constants.URIs.CAPABILITY_COMPONENT_API);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
	}
	
	
	
	
	
	public static String readResponseAsInputStream(Response r){
		String resultString = getStringFromInputStream((InputStream) r.getEntity());
		return resultString;
	}
	
	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
		
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testing
		System.out.println( SparqlClient.getMandatoryCapabilities());
	}

}
