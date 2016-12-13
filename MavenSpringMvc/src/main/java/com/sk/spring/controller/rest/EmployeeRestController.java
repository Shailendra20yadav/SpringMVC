package com.sk.spring.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.spring.model.EmployeeTeo;

@RestController
@RequestMapping(value="/rest")
public class EmployeeRestController {
	
	@RequestMapping(value="/getEmp",method=RequestMethod.GET,headers="Accept=application/json")
	public  EmployeeTeo getAllEmployee(@RequestParam(value = "empName", required = true) String empName){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
 
		EmployeeTeo teo = new EmployeeTeo();
		teo.setEmpName(empName);
		return teo;
	}

}
