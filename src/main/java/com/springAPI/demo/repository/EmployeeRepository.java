package com.springAPI.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springAPI.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "SELECT * FROM employees e WHERE e.full_name LIKE CONCAT('%',:query,'%')",nativeQuery = true)
	List<Employee> searchEmployees(String query);
}
