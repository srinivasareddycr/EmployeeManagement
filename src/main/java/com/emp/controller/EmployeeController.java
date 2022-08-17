package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
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
	
//	@DeleteMapping("deleteId/{id}")
//	public void deleteEmployee(@PathVariable int id)
//	{
//		service.deleteEmployee(id);
//	}
	
	
	
	@DeleteMapping("deleteId/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id)
	{
		System.out.println(id);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try
		{
			service.deleteEmployee(id);
		}catch(Exception e)
		{
			e.printStackTrace();
			responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	

	@DeleteMapping("/deleteAll")
	public ResponseEntity<Employee> deleteAllEmployees(Employee employee)
	{
		//System.out.println(id);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try
		{
			service.deleteAll(employee);
		}catch(Exception e)
		{
			e.printStackTrace();
			responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id ,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(service.updateEmployee(employee, id),HttpStatus.OK);
	}
	
}