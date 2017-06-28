package com.sk.spring.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.jpa.dao.EmployeeDao;
import com.sk.jpa.entities.Employee;
import com.sk.jpa.entities.Emprole;
import com.sk.jpa.repository.EmployeeRepository;
import com.sk.spring.model.EmpRoleTeo;
import com.sk.spring.model.EmployeeTeo;
import com.sk.spring.services.EmployeeService;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	private EmployeeRepository empRepository;

	public List<EmployeeTeo> getAllEmployees() {
		List<EmployeeTeo> teos = null;
		List<Employee> emps= employeeDao.getAllEmployees();
		if (emps !=null && emps.size()>0){
			 teos  = new ArrayList<EmployeeTeo>(emps.size());
			 for (Employee employee : emps) {
				 teos.add(copyEntityToTeo(employee));
			}
			 emps =null; 
		}
		return teos;
	}
	
	public EmployeeTeo validateLogin(EmployeeTeo teo){
		EmployeeTeo temp =null;
		Employee emp = empRepository.findByUsername(teo.getUserName());
		if(emp!=null && teo.getPassword().equals(emp.getPassword())){
			temp = copyEntityToTeo(emp);
		}
		return temp;
		
	}
	//@Transactional
	public long registerEmployee(EmployeeTeo teo){
		teo.setCreatedon(new Date());
		teo.setLastupdatedon(new Date());
		teo.setGender(1);
		Employee emp = empRepository.save(copyTeoToEntity(teo));
		return emp!=null ? emp.getEmployeeId():0;
				
	}
	
	private EmployeeTeo copyEntityToTeo(Employee empEntity){
		EmployeeTeo teo = new EmployeeTeo();
		teo.setEmpid(empEntity.getEmployeeId());
		teo.setFirstName(empEntity.getFirstname());
		teo.setMiddleName(empEntity.getLastname());
		teo.setLastName(empEntity.getLastname());
		teo.setEmail(empEntity.getEmail());
		teo.setUserName(empEntity.getUsername());
		teo.setPassword(empEntity.getPassword());
		teo.setCreatedon(empEntity.getCreatedon());
		teo.setLastupdatedon(empEntity.getLastupdatedon());
		List<Emprole> roles = empEntity.getEmproles();
		if(roles!=null && roles.size()>0){
			List<EmpRoleTeo> empRoles = new ArrayList<EmpRoleTeo>(roles.size());
			for (Emprole emprole : roles) {
				EmpRoleTeo empRoleTeo = new EmpRoleTeo();
				empRoleTeo.setEmployeeId(empEntity.getEmployeeId());
				empRoleTeo.setEmproleId(emprole.getEmproleId());
				empRoleTeo.setRolename(emprole.getRolename());
				empRoles.add(empRoleTeo);
			}
			teo.setEmproles(empRoles);
		}
		return teo;
	}
	
	private Employee copyTeoToEntity(EmployeeTeo teo){
		
		Employee emp = new Employee();
		emp.setEmployeeId(teo.getEmpid());
		emp.setFirstname(teo.getFirstName());
		emp.setLastname(teo.getLastName());
		emp.setMiddlename(teo.getMiddleName());
		emp.setEmail(teo.getEmail());
		emp.setUsername(teo.getUserName());
		emp.setPassword(teo.getPassword());
		emp.setGender(teo.getGender());
		emp.setCreatedon(teo.getCreatedon());
		emp.setLastupdatedon(teo.getLastupdatedon());
		List<EmpRoleTeo> roles = teo.getEmproles();
		if(roles!=null && roles.size()>0){
			List<Emprole> empRoles = new ArrayList<Emprole>(roles.size());
			for (EmpRoleTeo empRoleTeo : roles) {
				Emprole role = new Emprole();
				role.setEmployee(emp);
				role.setRolename(empRoleTeo.getRolename());
				empRoles.add(role);
				
			}
			emp.setEmproles(empRoles);
		}
		return emp;
	}
	

}
