package com.springAPI.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "teams")
public class Team {
	@Id
	@Column(name = "team_id")
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teamId;
	
	@Column(name = "name", nullable = false)
	private String name;
	


	public Team() {
	}

	public Team(long teamId) {
		this.teamId = teamId;
	}

	public Team(String name) {
		super();
		this.name = name;
	}


	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	
	
	
}
