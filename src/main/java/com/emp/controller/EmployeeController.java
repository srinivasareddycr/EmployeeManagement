package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@RequestMapping("/hello")

	public String hello()

	{
		return "Hello World";	
	}



	@PostMapping("/empCreate")
	public int  employeeCreated(@RequestBody Employee employee)
	{
		int id = service.saveEmployee(employee);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee()
	{
		return service.getEmployees();
	}
	
}