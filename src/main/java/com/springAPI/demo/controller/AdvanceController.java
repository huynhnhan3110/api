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
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.model.Advance;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.service.AdvanceService;

@RestController
@RequestMapping("/api/advances")
public class AdvanceController {
	private AdvanceService advanceService;
	public AdvanceController(AdvanceService advanceService) {
		this.advanceService = advanceService;
	}
	@GetMapping
	public List<Advance> getAllAdvance() {
		return advanceService.getAllAdvance();
	}
	
	@PostMapping
	public ResponseEntity<Advance> saveAdvance(@RequestBody Advance advance) {
		return new ResponseEntity<Advance>(advanceService.saveAdvance(advance), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public  ResponseEntity<Advance> getAdvanceById(@PathVariable("id") long id) {
		return new ResponseEntity<Advance>(advanceService.getAdvanceById(id), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAdvance(@PathVariable("id") long id) {
		advanceService.deleteAdvance(id);
		return new ResponseEntity<String>("Delete advance success", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Advance> updateAdvance(@PathVariable("id") long id, @RequestBody Advance advance) {
		return new ResponseEntity<Advance>(advanceService.updateAdvance(id, advance), HttpStatus.OK);
	}
}
