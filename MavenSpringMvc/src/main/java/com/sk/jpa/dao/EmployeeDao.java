package com.sk.jpa.dao;

import java.util.List;

import com.sk.jpa.entities.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
}
