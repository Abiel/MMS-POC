/**
 * 
 */
package com.accenture.techlabs.forms;

/**
 * @author abiel.m.woldu
 *
 */
public class Employee{
    private long id;
    private String firstName;
    private String lastName;
    private int hoursToWork;  // to be filled from Spring MVC form
    //default contructor and all getters and setters
    public Employee(){
    }
    
    public Employee(long id){
    	this.id=id;
    }
    
    public Employee(String firstName){
    	this.firstName = firstName;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getHoursToWork() {
		return hoursToWork;
	}

	public void setHoursToWork(int hoursToWork) {
		this.hoursToWork = hoursToWork;
	}
    
    
}