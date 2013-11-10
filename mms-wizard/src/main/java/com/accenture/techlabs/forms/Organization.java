/**
 * 
 */
package com.accenture.techlabs.forms;

import java.util.List;

/**
 * @author abiel.m.woldu
 *
 */
public class Organization{
    private long id;
    private String name;
    private List<Department> adminDepartmentList;   //n admin departments
    private List<Department> employeeDepartmentList;
    
	public Organization() {
	}
	public Organization(long id) {
		super();
		this.id = id;
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
	public List<Department> getAdminDepartmentList() {
		return adminDepartmentList;
	}
	public void setAdminDepartmentList(List<Department> adminDepartmentList) {
		this.adminDepartmentList = adminDepartmentList;
	}
	public List<Department> getEmployeeDepartmentList() {
		return employeeDepartmentList;
	}
	public void setEmployeeDepartmentList(List<Department> employeeDepartmentList) {
		this.employeeDepartmentList = employeeDepartmentList;
	} //m employee departments
// default constructor and all getters and setters
    
    
}
