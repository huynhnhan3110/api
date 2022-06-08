package com.springAPI.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
