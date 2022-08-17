package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exception.ResourceNotFoundException;
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

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		return findById;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll(Employee employee) {
		employeeRepository.deleteAll();
		
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "id", id));
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setEmailId(employee.getEmailId());
				
				employeeRepository.save(existingEmployee);
				return existingEmployee;
				
				
			
		
	}



}
