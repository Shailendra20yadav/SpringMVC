package com.sk.spring.services;

import java.util.List;

import com.sk.spring.model.EmployeeTeo;


public interface EmployeeService {

	public List<EmployeeTeo> getAllEmployees();
	public EmployeeTeo validateLogin(EmployeeTeo teo);
	public long registerEmployee(EmployeeTeo teo);
	public EmployeeTeo getEmployeeByUsername(String username);
}
