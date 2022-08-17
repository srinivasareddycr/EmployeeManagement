package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeServiceImplementation;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService service;



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
	
	
	@GetMapping("/getempId/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id)
	{
		Optional<Employee> employeeById = service.getEmployeeById(id);
		return employeeById;
	}
	
}