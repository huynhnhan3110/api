package com.springAPI.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.demo.model.Statistics;

public interface StatisticsService{
	List<Statistics> getAllStatisticEmployees();
}
