package com.springAPI.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springAPI.demo.model.Advance;
import com.springAPI.demo.model.Employee;

public interface AdvanceRepository extends JpaRepository<Advance, Long>{
	@Query(value = "SELECT * FROM advance WHERE employee_id = :employee_id", nativeQuery = true)
	List<Advance> getAdvanceByEmployeeId(String employee_id);
}
