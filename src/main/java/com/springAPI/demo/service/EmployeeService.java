package com.springAPI.demo.service;

import java.util.List;
import java.util.Map;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Map<String, Object> getAllEmployees(int pagaeNo, int pageSize, String sort);
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
	Employee updateEmployeeTeam(long id, Team team);
	List<Employee> searchEmployees(String full_name, String address, String position);
}
