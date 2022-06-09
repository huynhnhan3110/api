package com.springAPI.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;
import com.springAPI.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmployeeToExistTeam(@RequestParam (value = "team") long teamId, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployeeToExistTeam(teamId,employee), HttpStatus.CREATED);
	}


	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	@PutMapping("{id}/team")
	public ResponseEntity<Employee> updateEmployeeTeam(@PathVariable("id") long id, @RequestBody Team team) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeTeam(id, team), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee delete success", HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployees(
			@RequestParam(required = false, defaultValue = "") String full_name,
			@RequestParam(required = false, defaultValue = "") String address,
			@RequestParam(required = false, defaultValue ="") String position
			) {
		return new ResponseEntity<List<Employee>>(employeeService.searchEmployees(full_name, address, position), HttpStatus.OK);
	}
}
