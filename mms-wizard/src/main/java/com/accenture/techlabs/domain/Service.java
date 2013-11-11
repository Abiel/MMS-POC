/**
 * 
 */
package com.accenture.techlabs.domain;

import java.util.List;

/**
 * @author abiel.m.woldu
 *
 */
public class Service {
	private String uri;
	private String name;
	private List<AppComponent> appComponentList;
	private List<Adapter> adapterList;

	public Service() {
	}
	
	public Service(String uri){
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

	public List<AppComponent> getAppComponentList() {
		return appComponentList;
	}

	public void setAppComponentList(List<AppComponent> appComponentList) {
		this.appComponentList = appComponentList;
	}

	public List<Adapter> getAdapterList() {
		return adapterList;
	}

	public void setAdapterList(List<Adapter> adapterList) {
		this.adapterList = adapterList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
