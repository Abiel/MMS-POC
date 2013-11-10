/**
 * 
 */
package com.accenture.techlabs.forms;

import java.util.List;

/**
 * @author abiel.m.woldu
 *
 */
public class Department{
    private long id;
    private String name;
    private List<Employee> employeeList; //k employees
    //default constructor and all getters and setters
    
    public Department(){
    }
    
    public Department(long id){
    	this.id = id;
    }
    
    public Department(String name){
    	this.name = name;
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

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
    
    
}
