package com.springAPI.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.demo.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}
