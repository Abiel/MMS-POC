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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adapterList == null) ? 0 : adapterList.hashCode());
		result = prime
				* result
				+ ((appComponentList == null) ? 0 : appComponentList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
