package com.springAPI.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springAPI.demo.exception.ResourceNotFound;
import com.springAPI.demo.model.Advance;
import com.springAPI.demo.model.Working;
import com.springAPI.demo.repository.AdvanceRepository;
import com.springAPI.demo.service.AdvanceService;
@Service
public class AdvanceServiceImpl implements AdvanceService{
	private AdvanceRepository advanceRepository;
	public AdvanceServiceImpl(AdvanceRepository advanceRepository) {
		this.advanceRepository = advanceRepository;
	}
	
	@Override
	public List<Advance> getAllAdvance() {
		return advanceRepository.findAll();
	}

	@Override
	public Advance saveAdvance(Advance advance) {
		return advanceRepository.save(advance);
	}

	@Override
	public Advance getAdvanceById(long id) {
		return advanceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Advance not exist with id: "+id, "failed"));
	}

	@Override
	public void deleteAdvance(long id) {
		Advance existingAdvance = advanceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Advance not exist with id: "+id,"failed"));
		advanceRepository.deleteById(existingAdvance.getId());
	}

	@Override
	public Advance updateAdvance(long id, Advance advance) {
		Advance existingAdvance = advanceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Advance not exist with id: "+id,"failed"));
		existingAdvance.setDate_time(advance.getDate_time());
		existingAdvance.setEmployee_id(advance.getEmployee_id());
		existingAdvance.setMoney(advance.getMoney());
		advanceRepository.save(existingAdvance);
		return existingAdvance;
	}
		
	@Override
	public List<Advance> getAdvanceByEmployee(long id) {
		List<Advance> allAdvances = advanceRepository.findAll();
		List<Advance> filteredAdvance = new ArrayList<Advance>();
		for(Advance advance : allAdvances) {
			if(advance.getEmployee_id() == (int)id) {
				filteredAdvance.add(advance);
			}
		}
		if(!filteredAdvance.isEmpty()) {			
			return filteredAdvance;
		}
		else {
			throw new ResourceNotFound("Employee not exist with id:" + id,"failed");
		}
	}
}
