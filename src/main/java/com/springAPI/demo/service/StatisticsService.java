package com.springAPI.demo.service;

import java.util.List;

import com.springAPI.demo.model.Statistics;

public interface StatisticsService{
	List<Statistics> saveStatistic(List<Statistics> statistics);
	List<Statistics> calculateStatisticEmployees();
	List<Statistics> getAllStatisticEmployees();
	Statistics getStatisticsByEmployeeId(long id);
}
