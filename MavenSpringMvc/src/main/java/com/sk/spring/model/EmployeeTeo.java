package com.sk.spring.model;

public class EmployeeTeo {
	private String empName;
	private long empId;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public EmployeeTeo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeTeo(String empName, long empId) {
		super();
		this.empName = empName;
		this.empId = empId;
	}
	

}
