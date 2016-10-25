package com.sk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sk.jpa.entities.Employee;
import com.sk.spring.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
    EmployeeService employeeService;
	
	@RequestMapping("/login")
	public ModelAndView getAllEmployee(){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
 
		ModelAndView mv = new ModelAndView("employeeDetails");
		List<Employee> emp = employeeService.getAllEmployees();
		mv.addObject("employees", emp);
		if(emp!=null && emp.size() >0){
			for (Employee employee : emp) {
				System.out.println(employee.getFirstname());
			}
		}
		return mv;
	}

}
