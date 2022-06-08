package com.springAPI.demo.service;

import java.util.List;

import com.springAPI.demo.model.Employee;
import com.springAPI.demo.model.Working;

public interface WorkingService {
	Working saveWorking(Working working);
	List<Working> getAllWorkings();
	Working getWorkingById(long id);
	Working updateWorking(Working working, long id);
	void deleteWorking(long id);

//	List<Working> getWorkingByEmployee(long id);
}
