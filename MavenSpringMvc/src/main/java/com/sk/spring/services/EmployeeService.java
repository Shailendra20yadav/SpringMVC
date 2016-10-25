package com.sk.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sk.jpa.entities.Employee;


public interface EmployeeService {

	public List<Employee> getAllEmployees();
}
