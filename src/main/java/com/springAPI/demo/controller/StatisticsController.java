package com.springAPI.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.model.Statistics;
import com.springAPI.demo.service.StatisticsService;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
	private StatisticsService statisticsService;
	public StatisticsController(StatisticsService service) {
		this.statisticsService = service;
	}
	
	@GetMapping
	public List<Statistics> getAllStatisticEmployees() {
		return statisticsService.getAllStatisticEmployees();
	}
	
	@PostMapping
	public List<Statistics> saveStatistic() {
		return statisticsService.saveStatistic(statisticsService.calculateStatisticEmployees());
	}
	
	@GetMapping(params = "employeeId")
	public ResponseEntity<Statistics> getstatisticsByEmployee(long employeeId) {
		return new ResponseEntity<Statistics>(statisticsService.getStatisticsByEmployeeId(employeeId), HttpStatus.OK);
	}
}
