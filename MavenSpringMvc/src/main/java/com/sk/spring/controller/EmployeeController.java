package com.sk.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sk.spring.model.EmployeeTeo;
import com.sk.spring.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
    EmployeeService employeeService;
	
	@RequestMapping("/viewAllEmp")
	public ModelAndView getAllEmployee(){
			//@RequestParam(value = "userName", required = true) String name,@RequestParam(value = "password", required = true) String password) {
 
		ModelAndView mv = new ModelAndView("employeeDetails");
		List<EmployeeTeo> emp = employeeService.getAllEmployees();
		mv.addObject("employees", emp);
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView showLoginPage(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("emp", new EmployeeTeo());
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage(){
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("emp", new EmployeeTeo());
		return mav;
	}
	
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)

	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("emp") EmployeeTeo login) {
		  EmployeeTeo emp = employeeService.validateLogin(login);
		  ModelAndView mav = new ModelAndView("welcome");
		  mav.addObject("emp",emp);
		  
		  return mav;
		  
	  }
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)

	  public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("emp") EmployeeTeo teo) {
		  long empId = employeeService.registerEmployee(teo);
		  if(empId > 0)
			  teo.setEmpid(empId);
		  ModelAndView mav = new ModelAndView("welcome");
		  mav.addObject("emp",teo);
		  
		  return mav;
		  
	  }

}
