/**
 * 
 */
package com.accenture.techlabs.domain;

import java.util.List;

/**
 * @author abiel.m.woldu
 *
 */
public class Product {
	private String name;
	private String uri;
	private List<Capability> optionalCapabilityList;
	private List<Capability> mandatoryCapabilityList;

	/**
	 * 
	 */
	public Product() {
	}
	
	public Product(String uri){
		this.uri = uri;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}


	public List<Capability> getOptionalCapabilityList() {
		return optionalCapabilityList;
	}


	public void setOptionalCapabilityList(List<Capability> optionalCapabilityList) {
		this.optionalCapabilityList = optionalCapabilityList;
	}


	public List<Capability> getMandatoryCapabilityList() {
		return mandatoryCapabilityList;
	}


	public void setMandatoryCapabilityList(List<Capability> mandatoryCapabilityList) {
		this.mandatoryCapabilityList = mandatoryCapabilityList;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
