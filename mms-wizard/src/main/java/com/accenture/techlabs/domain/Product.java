/**
 * 
 */
package com.accenture.techlabs.domain;

/**
 * @author abiel.m.woldu
 *
 */
public class Product {
	private long id;
	private String name;

	/**
	 * 
	 */
	public Product() {
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
