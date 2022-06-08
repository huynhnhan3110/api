package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Statistics;
import com.springAPI.demo.model.Working;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.repository.StatisticRepository;
import com.springAPI.demo.repository.TeamRepository;
import com.springAPI.demo.repository.WorkingRepository;
import com.springAPI.demo.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService{
	private EmployeeRepository employeeRepository;
	private WorkingRepository	workingRepository;
	private StatisticRepository statisticRepository;
	
	public StatisticsServiceImpl(EmployeeRepository employeeRepository, WorkingRepository workingRepository,StatisticRepository statisticRepository) {
		this.employeeRepository = employeeRepository;
		this.workingRepository = workingRepository;
		this.statisticRepository = statisticRepository;
	}
	
	@Override
	public List<Statistics> getAllStatisticEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<Statistics> statistics = new ArrayList<Statistics>();
		for(Employee e: employees) {
			List<Working> workings = workingRepository.findAll();
			double sumOfHourEachEmployee = 0;
			for(Working working : workings) {
				if(working.getEmployee_id() == e.getId()) {
					sumOfHourEachEmployee+=working.getNumberHour();
				}
			}
			Statistics statisticsEachEmployee = new Statistics();
			statisticsEachEmployee.setNo_of_employee((int)e.getId());
			statisticsEachEmployee.setMoney(e.getMoneyPerHour() * sumOfHourEachEmployee);
			statistics.add(statisticsEachEmployee);
		}
		statisticRepository.saveAll(statistics);
		return statistics;
	}
	
}
