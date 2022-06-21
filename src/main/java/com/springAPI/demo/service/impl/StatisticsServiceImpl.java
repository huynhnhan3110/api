package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springAPI.demo.model.Advance;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Statistics;
import com.springAPI.demo.model.Working;
import com.springAPI.demo.repository.AdvanceRepository;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.repository.StatisticRepository;
import com.springAPI.demo.repository.WorkingRepository;
import com.springAPI.demo.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService{
	private EmployeeRepository employeeRepository;
	private WorkingRepository	workingRepository;
	private StatisticRepository statisticRepository;
	private AdvanceRepository advanceRepository;
	@Autowired
	private WorkingServiceImpl workingService = new WorkingServiceImpl(workingRepository);
	
	public StatisticsServiceImpl(EmployeeRepository employeeRepository, 
			WorkingRepository workingRepository,
			StatisticRepository statisticRepository,
			AdvanceRepository advanceRepository) {
		this.employeeRepository = employeeRepository;
		this.workingRepository = workingRepository;
		this.statisticRepository = statisticRepository;
		this.advanceRepository = advanceRepository;
	}
	
	@Override
	public List<Statistics> calculateStatisticEmployees() {
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
			Statistics statisticsPerEmployee = new Statistics();
			statisticsPerEmployee.setNo_of_employee((int)e.getId());
			double totalWithoutAdvance = e.getMoneyPerHour() * sumOfHourEachEmployee;
			String employeeIdStr = Long.toString(e.getId());
			List<Advance> advancesByEmployee = advanceRepository.getAdvanceByEmployeeId(employeeIdStr);
			double totalAdvance = 0;
			for(Advance advance : advancesByEmployee) {
				totalAdvance += advance.getMoney();
			}
			statisticsPerEmployee.setMoney(totalWithoutAdvance - totalAdvance); // update to table
			statistics.add(statisticsPerEmployee); 
		}
		return statistics;
	}
		
	@Override
	public List<Statistics> saveStatistic(List<Statistics> statistics) {
		return statisticRepository.saveAll(statistics);
	}
	
	@Override
	public List<Statistics> getAllStatisticEmployees() {
		return statisticRepository.findAll();
	}
	
	
	

	@Override
	public Statistics getStatisticsByEmployeeId(long id) {
		
		List<Working> workingListByEmployee = workingService.getWorkingByEmployee(id);
		double totalHour = 0;
		for(Working work : workingListByEmployee) {
			totalHour += work.getNumberHour();
		}
		Statistics statisticsByEmployee = new Statistics((int) id, totalHour*employeeRepository.getById(id).getMoneyPerHour());
		return statisticsByEmployee;
	}

	
	
}
