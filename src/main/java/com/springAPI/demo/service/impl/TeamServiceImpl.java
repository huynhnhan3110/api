package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;
import com.springAPI.demo.repository.EmployeeRepository;
import com.springAPI.demo.repository.TeamRepository;
import com.springAPI.demo.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService{
	private TeamRepository teamRepository;
	private EmployeeRepository employeeRepository;

	public TeamServiceImpl(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
		this.teamRepository = teamRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public List<Team> getAllTeams() {
		return (List<Team>) teamRepository.findAll();
	}
	
	@Override
	public List<Employee> getEmployeesByTeam(long id) {
		List<Employee> allEmployees = employeeRepository.findAll();
		List<Employee> filteredEmployees = new ArrayList<Employee>();
		for(Employee e : allEmployees) {
			if(e.getTeam().getTeamId() == (int)id) {
				filteredEmployees.add(e);
			}
		}
		return filteredEmployees;
	}
	
	@Override
	public Team getTeamById(long id) {
		return teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team not exist with id: "+ id));
	}

	@Override
	public Team updateTeam(Team team, long id) {
		Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team not exist with id: "+ id));
		existingTeam.setName(team.getName());
		teamRepository.save(existingTeam);
		return existingTeam;
	}

	@Override
	public void deleteTeam(long id) {
		Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team not exist with id: "+ id));
		teamRepository.delete(existingTeam);
	}
	

}
