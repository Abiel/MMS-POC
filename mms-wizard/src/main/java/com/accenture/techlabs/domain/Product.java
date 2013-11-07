/**
 * 
 */
package com.accenture.techlabs.domain;

import java.util.Arrays;

/**
 * @author abiel.m.woldu
 *
 */
public class Product {
	private String name;
	private String[] capability;

	/**
	 * 
	 */
	public Product() {
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getCapability() {
		return capability;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(capability);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Product other = (Product) obj;
		if (!Arrays.equals(capability, other.capability))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}






	public void setCapability(String[] capability) {
		this.capability = capability;
	}






	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
