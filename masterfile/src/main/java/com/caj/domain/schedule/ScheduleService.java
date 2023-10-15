package com.caj.domain.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	/**
	 * stationRepository
	 */
	@Autowired
	ScheduleRepository scheduleRepository;
	
	/**
	 * getScheduleDoList
	 * 
	 * @return
	 */
	public List<ScheduleDo> getScheduleDoList() {
		return scheduleRepository.findSchedules();
	}
}
