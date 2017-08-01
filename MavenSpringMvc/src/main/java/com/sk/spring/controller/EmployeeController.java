package com.sk.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout){
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		model.addObject("emp", new EmployeeTeo());
		return model;
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView showWelcomePage(Principal user) {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			EmployeeTeo emp = employeeService.getEmployeeByUsername(userDetail.getUsername());
			if(emp==null){
				model.addObject("invalidUserMessage", msgResource.getMessage("login.invalidLogin",null,LocaleContextHolder.getLocale()));
				model.addObject("emp", new EmployeeTeo());

				return model;
			}
			model.addObject("emp",emp);
			model.setViewName("welcome");

		}
		return model;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		System.out.println("controller logout called......");
		return "forward:perform_logout";
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage(){
		ModelAndView mav = new ModelAndView("register");
		Map<String,String> roles = new LinkedHashMap<String,String>();
		roles.put("USER", "User");
		roles.put("ADMIN", "Admin");
		Map<String,String> enableStatus = new LinkedHashMap<String,String>();
		enableStatus.put("1", "Enable");
		enableStatus.put("0", "Disable");
		mav.addObject("emp", new EmployeeTeo());
		mav.addObject("roles",roles);
		mav.addObject("enableStatus",enableStatus);
		return mav;
	}
	
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)

	  public String loginProcess(HttpServletRequest request,@ModelAttribute("emp") EmployeeTeo login,BindingResult result,Model model) {
		  		//loginValidator.validate(login, result);
			    
		  if(StringUtils.isEmpty(login.getUsername())){
			  result.rejectValue("username", "NotEmpty.userForm.userName");
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
		  request.getSession().setAttribute("LOGGEDIN_USER", emp);

		  return "welcome";

	  }
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)

	  public String registerProcess(HttpServletRequest request,@ModelAttribute("emp") EmployeeTeo teo,BindingResult result,Model model) {
		  empValidator.validate(teo, result);
		//Check validation errors
		    if (result.hasErrors()) {
		    	return "register";
		    }
		  
		  long empId = employeeService.registerEmployee(teo);
		  if(empId > 0){
			  teo.setEmpid(empId);
			  model.addAttribute("emp", teo);
			  request.getSession().setAttribute("LOGGEDIN_USER", teo);
			  return "welcome";
		  }else{
			  return "register";
		  }
		  
		  
		  
	  }
	  
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied(Principal user) {

			ModelAndView model = new ModelAndView();
			// check if user is login
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addObject("username", userDetail.getUsername());
			}

			model.setViewName("403");
			return model;
		}

		@RequestMapping(value = "/404")
		public String handle404() {
			return "404";
		}

		@RequestMapping(value = "/error")
		public String handleError() {
			return "error";
		}

}
