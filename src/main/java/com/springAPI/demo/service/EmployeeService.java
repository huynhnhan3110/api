package com.springAPI.demo.service;

import java.util.List;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);

	Employee saveEmployeeToExistTeam(long teamId, Employee employee);
	Employee updateEmployeeTeam(long id, Team team);
	List<Employee> searchEmployees(String fullName, String address, String position);
}
