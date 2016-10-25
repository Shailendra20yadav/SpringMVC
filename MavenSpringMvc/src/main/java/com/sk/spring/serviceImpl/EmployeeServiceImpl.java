package com.sk.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.jpa.dao.EmployeeDao;
import com.sk.jpa.entities.Employee;
import com.sk.spring.services.EmployeeService;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	

}
