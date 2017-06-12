package com.sk.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.jpa.entities.Employee;
import com.sk.spring.model.EmployeeTeo;
import com.sk.spring.services.EmployeeService;

@RestController
@RequestMapping(value="/rest")

public class EmployeeRestController {
	
	
	@Autowired
    EmployeeService employeeService;
	
	@RequestMapping(value="/getEmp",method=RequestMethod.GET)
	public  EmployeeTeo getAllEmployee(@RequestParam(value = "empName", required = true) String empName){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
		
		List<EmployeeTeo> emp = employeeService.getAllEmployees();
		if(emp!=null && emp.size() >0){
			for (EmployeeTeo employee : emp) {
				System.out.println(employee.getFirstName());
			}
		}
 
		EmployeeTeo teo = new EmployeeTeo();
		teo.setEmpName(empName);
		return teo;
	}
	
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public  void saveEmployee(@RequestBody EmployeeTeo teo){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
 
		
		System.out.println("saveEmp Post example"+teo.getEmpName());
	}
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.POST)
	public  void updateEmployee(){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
 
		
		System.out.println("updateEmp Post example");
	}

}
