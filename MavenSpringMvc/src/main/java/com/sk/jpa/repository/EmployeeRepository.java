package com.sk.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.jpa.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByUsername(String username);

}
