package com.springAPI.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Team;
import com.springAPI.demo.repository.TeamRepository;
import com.springAPI.demo.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService{
	private TeamRepository teamRepository;
	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getTeamById(long id) {
		return teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team", "id", id));
	}

	@Override
	public Team updateTeam(Team team, long id) {
		Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team", "id", id));
		existingTeam.setName(team.getName());
		teamRepository.save(existingTeam);
		return existingTeam;
	}

	@Override
	public void deleteTeam(long id) {
		Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Team", "id", id));
		teamRepository.delete(existingTeam);
	}
	

}
