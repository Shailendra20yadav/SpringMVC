package com.sk.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sk.jpa.entities.Employee;
import com.sk.spring.model.EmployeeTeo;


public interface EmployeeService {

	public List<EmployeeTeo> getAllEmployees();
	public EmployeeTeo validateLogin(EmployeeTeo teo);
	public long registerEmployee(EmployeeTeo teo);
}
