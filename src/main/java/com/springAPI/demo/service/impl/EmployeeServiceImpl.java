package com.springAPI.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.springAPI.demo.model.Team;
import com.springAPI.demo.repository.TeamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	private TeamRepository teamRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.teamRepository = teamRepository;
	}
	// Create Employee
	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Team> team = teamRepository.findById(employee.getTeam().getTeamId());
		if(team.isPresent()) {
			employee.setTeam(team.get());
			return employeeRepository.save(employee);
		} else {
			throw  new ResourceNotFound("Team not exist","failed");
		}
	}

	
	@Override
	public Map<String, Object> getAllEmployees(String pageNoStr, String pageSizeStr, String search) {
		List<Employee> allEmployees = employeeRepository.findAll();
		if(pageSizeStr==null && pageNoStr==null) {
			Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("total", allEmployees.size());
			mapResult.put("data", allEmployees);
			return mapResult;
		}
		List<Employee> filteredEmployee = allEmployees.stream().filter((item) -> {
			return item.getFullName().toLowerCase().contains(search.toLowerCase());
		}).collect(Collectors.toList());
		
		Map<String, Object> mapResult = new HashMap<>();
		try {
			int pageNo = Integer.parseInt(pageNoStr);
			int pageSize = Integer.parseInt(pageSizeStr);
			List<Employee> paginatedEmployee = filteredEmployee.stream().skip((pageNo - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
			mapResult.put("total", filteredEmployee.size());
			mapResult.put("data", paginatedEmployee);
			return mapResult;
		}catch (Exception e) {
			return mapResult;
		}
		
	}

	
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFound("Employee not exist with id:" + id,"failed");
		}
	}
	
	
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employeee not exist with id: "+ id,"failed"));
		existingEmployee.setFullName(employee.getFullName());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setMoneyPerHour(employee.getMoneyPerHour());
		existingEmployee.setPhoneNumber(employee.getPhoneNumber());
		existingEmployee.setStartDate(employee.getStartDate());
		existingEmployee.setSex(employee.getSex());
		existingEmployee.setPosition(employee.getPosition());
		
		Optional<Team> team = teamRepository.findById(employee.getTeam().getTeamId());
		System.out.println(team.get().getTeamId());
		if(team.isPresent()) {
			existingEmployee.setTeam(team.get());
			return employeeRepository.save(existingEmployee);
			
		} else {
			throw new ResourceNotFound("Team not exist","failed");
		}
	}
	
	@Override
	public Employee updateEmployeeTeam(long id, Team team) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employeee not exist with id: "+ id,"failed"));
		existingEmployee.setTeam(team);
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	@Override
	public void deleteEmployee(long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employeee not exist with id: "+ id,"failed"));
		existingEmployee.removeTeam();
		employeeRepository.deleteById(existingEmployee.getId());
	}
	@Override
	public Page<Employee> searchEmployees(String full_name, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.Direction.ASC,"employee_id");
		return employeeRepository.findByName(full_name, pageRequest);
	}


}
