package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.model.Employee;

public interface IEmployeeService {

	
	public int saveEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Optional<Employee> getEmployeeById(int id);
}
