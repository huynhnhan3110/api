package com.springAPI.demo.service;

import java.util.List;

import com.springAPI.demo.model.Team;

public interface TeamService {
	Team saveTeam(Team temam);
	List<Team> getAllTeams();
	Team getTeamById(long id);
	Team updateTeam(Team team, long id);
	void deleteTeam(long id);
}
