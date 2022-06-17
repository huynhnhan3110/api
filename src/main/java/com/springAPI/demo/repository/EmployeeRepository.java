package com.springAPI.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springAPI.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "SELECT * FROM employees WHERE full_name LIKE CONCAT('%',:full_name,'%')", nativeQuery = true)
	Page<Employee> findByName(String full_name, PageRequest pageRequest);
}
