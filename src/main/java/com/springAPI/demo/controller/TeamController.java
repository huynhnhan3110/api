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

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;
import com.springAPI.demo.service.TeamService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/teams")
public class TeamController {
	private TeamService teamService;
	
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	@PostMapping
	public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
		return new ResponseEntity<Team>(teamService.saveTeam(team), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable("id") long id) {
		return new ResponseEntity<Team>(teamService.getTeamById(id), HttpStatus.OK);
	}
	
	@GetMapping("{teamId}/employees")
	public List<Employee> getEmployeeByTeamId(@PathVariable("teamId") long id) {
		return teamService.getEmployeesByTeam(id);
	}

	@PutMapping("{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable("id") long id, @RequestBody Team team) {
		return new ResponseEntity<Team>(teamService.updateTeam(team, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeam(@PathVariable("id") long id) {
		teamService.deleteTeam(id);
		return new ResponseEntity<String>("Delete team success", HttpStatus.OK);
	}
}
