package com.sk.jpa.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sk.jpa.dao.EmployeeDao;
import com.sk.jpa.entities.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
    private EntityManager manager;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = manager.createQuery("Select a From Employee emp", Employee.class).getResultList();
        return employees;
	}

}
