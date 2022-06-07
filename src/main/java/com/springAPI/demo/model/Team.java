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
	
	
	@OneToMany(mappedBy = "team")
	@JsonManagedReference
	private List<Employee> employees;
	public Team() {
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	
	public Team(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
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

	

	@Override
	public int hashCode() {
		return Objects.hash(employees, name, teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(employees, other.employees) && Objects.equals(name, other.name) && teamId == other.teamId;
	}

	
	
	
}
