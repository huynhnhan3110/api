package com.springAPI.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
	@Query(value="SELECT employees FROM teams e WHERE e.team_id = :id",nativeQuery = true)
	public List<Employee> getEmployeesByTeam(@Param("id") long id);
}
