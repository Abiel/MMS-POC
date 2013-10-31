/**
 * 
 */
package com.accenture.techlabs.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import com.accenture.techlabs.constants.Constants;

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
	
	public static String getMandatoryCapabilities(){
		WebClient client = WebClient.create(Constants.URIs.PRODUCTS);
		client.accept(MediaType.APPLICATION_JSON);
		String r = client.get(String.class);
		//Response response = client.get();       								//Another way to query.
		//String responseString = readResponseAsInputStream(response);
		return r;
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
