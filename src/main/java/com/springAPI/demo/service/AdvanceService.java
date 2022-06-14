package com.springAPI.demo.service;
import java.util.List;

import com.springAPI.demo.model.Advance;
public interface AdvanceService {
	Advance saveAdvance(Advance advance);
	Advance getAdvanceById(long id);
	void deleteAdvance(long id);
	List<Advance> getAllAdvance();
	Advance updateAdvance(long id, Advance advance);
}
