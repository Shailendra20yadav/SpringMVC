package com.sk.spring.model;

import java.util.Date;
import java.util.List;

public class EmployeeTeo {
	private long empid;
	private String firstName;
	private String lastName;
	private String middleName;
	private String password;
	private String username;
	private int enabled;
	public String getUsername() {
		return username;
	}
	public EmployeeTeo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeTeo(String username,String password) {
		super();
		this.password = password;
		this.username = username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String email;
	private Date lastupdatedon;
	private Date createdon;
	private String empName;
	private int gender;
	private List<EmpRoleTeo> emproles;
	
	public List<EmpRoleTeo> getEmproles() {
		return emproles;
	}
	public void setEmproles(List<EmpRoleTeo> emproles) {
		this.emproles = emproles;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Date getLastupdatedon() {
		return lastupdatedon;
	}
	public void setLastupdatedon(Date lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	

}
