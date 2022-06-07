package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	// Create Employee
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	// Get All Employee
	@Override
	public List<Employee> getAllEmployees() {
			List<Employee> liste = employeeRepository.findAll();
			System.out.println(liste);
			return liste;
	}
	
	// Get Employee by ID
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFound("Employee", "Id", id);
		}
	}
	
	// Update Employee by ID
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employeee","id", id));
		existingEmployee.setFullName(employee.getFullName());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setMoneyPerHour(employee.getMoneyPerHour());
		existingEmployee.setSex(employee.getSex());
		existingEmployee.setPosition(employee.getPosition());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	@Override
	public void deleteEmployee(long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "id", id));
		employeeRepository.delete(existingEmployee);
	}

	
	
	

}
