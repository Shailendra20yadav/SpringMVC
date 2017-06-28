package com.sk.spring.model;

import javax.persistence.*;


public class EmpRoleTeo {
	
	private long emproleId;
	private long employeeId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	private String rolename;

	//bi-directional many-to-one association to Employee
	

	public EmpRoleTeo() {
	}

	public long getEmproleId() {
		return this.emproleId;
	}

	public void setEmproleId(long emproleId) {
		this.emproleId = emproleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	

}