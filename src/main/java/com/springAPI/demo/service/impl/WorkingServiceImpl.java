package com.springAPI.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Working;
import com.springAPI.demo.repository.WorkingRepository;
import com.springAPI.demo.service.WorkingService;
@Service
public class WorkingServiceImpl implements WorkingService{
	private WorkingRepository workingRepository;
	
	public WorkingServiceImpl(WorkingRepository workingRepository) {
		this.workingRepository = workingRepository;
	}
	@Override
	public Working saveWorking(Working working) {
		
		return workingRepository.save(working);
	}

	@Override
	public List<Working> getAllWorkings() {
		return (List<Working>) workingRepository.findAll();
	}
	
	
	@Override
	public Working getWorkingById(long id) {
		return workingRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Working", "id", id));
	}

	@Override
	public Working updateWorking(Working working, long id) {
		Working existingWorking = workingRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Working", "id", id));
		existingWorking.setNumberHour(working.getNumberHour());
		workingRepository.save(existingWorking);
		return existingWorking;
	}

	@Override
	public void deleteWorking(long id) {
		Working existingWorking = workingRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Working", "id", id));
		workingRepository.delete(existingWorking);
	}
//	@Override
//	public List<Working> getWorkingByEmployee(long id) {
//		List<Working> allWorkings = workingRepository.findAll();
//		List<Working> filteredWorking = new ArrayList<Working>();
//		for(Working w : allWorkings) {
//			if(w.getEmployee_id() == (int)id) {
//				filteredWorking.add(w);
//			}
//		}
//		return filteredWorking;
//	}

}
