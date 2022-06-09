package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springAPI.demo.model.Team;
import com.springAPI.demo.repository.TeamRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	private TeamRepository teamRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.teamRepository = teamRepository;
	}
	// Create Employee
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee saveEmployeeToExistTeam(long teamId, Employee employee) {
		Team team = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team","id", teamId));
		employee.setTeam(team);
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
	public Employee updateEmployeeTeam(long id, Team team) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employeee","id", id));
		existingEmployee.setTeam(team);
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	@Override
	public void deleteEmployee(long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "id", id));
		existingEmployee.removeTeam();
		employeeRepository.delete(existingEmployee);
	}

	@Override
	public
	List<Employee> searchEmployees(String query) {
		return employeeRepository.searchEmployees(query);
	}


}
