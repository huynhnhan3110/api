package com.springAPI.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.exception.Message;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;
import com.springAPI.demo.service.EmployeeService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

	
	@GetMapping
	public List<Employee> getAllEmployees(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		      @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		return employeeService.getAllEmployees(page, size,sort);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	@PutMapping("{id}/team")
	public ResponseEntity<Employee> updateEmployeeTeam(@PathVariable("id") long id, @RequestBody Team team) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeTeam(id, team), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Message> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Message>(new Message("Employee delete success", "success"), HttpStatus.OK);
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
