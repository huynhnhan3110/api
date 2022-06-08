package com.springAPI.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.demo.model.Employee;
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

}
