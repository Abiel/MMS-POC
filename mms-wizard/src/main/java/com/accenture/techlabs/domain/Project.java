/**
 * 
 */
package com.accenture.techlabs.domain;

import java.util.List;

/**
 * @author abiel.m.woldu
 *
 */
public class Project {
	private String projectName;
	private String clientName;
	private String projectCountry;
	private String projectDescription;
	private String deliveryCenter;
	private String sharedModel;
	
	//a project has one or more products
	private List<Product> productList;
	

	/**
	 * 
	 */
	public Project() {
	}	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProjectCountry() {
		return projectCountry;
	}

	public void setProjectCountry(String projectCountry) {
		this.projectCountry = projectCountry;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getDeliveryCenter() {
		return deliveryCenter;
	}

	public void setDeliveryCenter(String deliveryCenter) {
		this.deliveryCenter = deliveryCenter;
	}

	public String getSharedModel() {
		return sharedModel;
	}

	public void setSharedModel(String sharedModel) {
		this.sharedModel = sharedModel;
	}	

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result
				+ ((deliveryCenter == null) ? 0 : deliveryCenter.hashCode());
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		result = prime * result
				+ ((projectCountry == null) ? 0 : projectCountry.hashCode());
		result = prime
				* result
				+ ((projectDescription == null) ? 0 : projectDescription
						.hashCode());
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((sharedModel == null) ? 0 : sharedModel.hashCode());
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
		Project other = (Project) obj;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (deliveryCenter == null) {
			if (other.deliveryCenter != null)
				return false;
		} else if (!deliveryCenter.equals(other.deliveryCenter))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (projectCountry == null) {
			if (other.projectCountry != null)
				return false;
		} else if (!projectCountry.equals(other.projectCountry))
			return false;
		if (projectDescription == null) {
			if (other.projectDescription != null)
				return false;
		} else if (!projectDescription.equals(other.projectDescription))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (sharedModel == null) {
			if (other.sharedModel != null)
				return false;
		} else if (!sharedModel.equals(other.sharedModel))
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
