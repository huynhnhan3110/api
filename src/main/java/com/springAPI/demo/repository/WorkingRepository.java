package com.springAPI.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.demo.model.Working;

public interface WorkingRepository extends JpaRepository<Working, Long>{
	
}
