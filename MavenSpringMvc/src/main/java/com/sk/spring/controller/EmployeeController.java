package com.sk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sk.spring.model.EmployeeTeo;
import com.sk.spring.services.EmployeeService;
import com.sk.spring.validator.EmployeeValidator;
import com.sk.spring.validator.LoginValidator;

@Controller
public class EmployeeController {
	
	@Autowired
    EmployeeService employeeService;
	
	@Autowired
	EmployeeValidator empValidator;
	@Autowired
	LoginValidator loginValidator;
	
	@Autowired
	protected MessageSource msgResource;
	
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

	  public String loginProcess(@ModelAttribute("emp") EmployeeTeo login,BindingResult result,Model model) {
		  		//loginValidator.validate(login, result);
			    
		  if(StringUtils.isEmpty(login.getUserName())){
		  }
		  if(StringUtils.isEmpty(login.getPassword())){
			  result.rejectValue("password", "NotEmpty.userForm.password");
		  }
		  if (result.hasErrors()) {
			  model.addAttribute("emp", login);
		    	return "login";
		    }
		  EmployeeTeo emp = employeeService.validateLogin(login);
		  if(emp==null){
			  model.addAttribute("invalidUserMessage", msgResource.getMessage("login.invalidLogin",null,LocaleContextHolder.getLocale()));
			  model.addAttribute("emp", login);
			  return "login";
		  }
		  model.addAttribute("emp",emp);

		  return "welcome";

	  }
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)

	  public String registerProcess(@ModelAttribute("emp") EmployeeTeo teo,BindingResult result,Model model) {
		  empValidator.validate(teo, result);
		//Check validation errors
		    if (result.hasErrors()) {
		    	return "register";
		    }
		  
		  long empId = employeeService.registerEmployee(teo);
		  if(empId > 0){
			  teo.setEmpid(empId);
			  model.addAttribute("emp", teo);
		  }
		  
		  return "welcome";
		  
	  }

}
