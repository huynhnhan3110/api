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
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.model.Working;
import com.springAPI.demo.service.WorkingService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/working")
public class WorkingController {
	private WorkingService workingService;
	
	public WorkingController(WorkingService workingService) {
		this.workingService = workingService;
	}
	@PostMapping
	public ResponseEntity<Working> saveWorking(@RequestBody Working working) {
		return new ResponseEntity<Working>(workingService.saveWorking(working), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Working> getAllWorking() {
		return workingService.getAllWorkings();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Working> getWorkingById(@PathVariable("id") long id) {
		return new ResponseEntity<Working>(workingService.getWorkingById(id), HttpStatus.OK);
	}
	@GetMapping(params = "employeeId")
	public ResponseEntity<List<Working>> getWorkingByEmployee(long employeeId) {
		return new ResponseEntity<List<Working>>(workingService.getWorkingByEmployee(employeeId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Working> updateWorking(@PathVariable("id") long id, @RequestBody Working working) {
		return new ResponseEntity<Working>(workingService.updateWorking(working, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWorking(@PathVariable("id") long id) {
		workingService.deleteWorking(id);
		return new ResponseEntity<String>("Delete working success", HttpStatus.OK);
	}
}
