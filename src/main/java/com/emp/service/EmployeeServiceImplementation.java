package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;

@Service
public class EmployeeServiceImplementation implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	
	public int saveEmployee(Employee employee) {
		Employee savedEmployee =employeeRepository.save(employee);
		return savedEmployee.getId();
	}

	@Override
	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}



}
