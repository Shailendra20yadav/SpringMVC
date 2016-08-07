package com.sk.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sk.spring.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
    EmployeeService empService;

}
