package com.caj.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.schedule.ScheduleDo;
import com.caj.domain.schedule.ScheduleRepository;
import com.caj.infra.repository.mapper.ScheduleDao;

@Service
public class ScheduleRepositoryImpl implements ScheduleRepository{

	@Autowired
	ScheduleDao scheduleDao;
	
	/**
	 * Find Schedules
	 */
	@Override
	public List<ScheduleDo> findSchedules() {
		List<ScheduleDo> scheduleDoList=new ArrayList<>();
		scheduleDao.findAll().forEach(item -> {
			ScheduleDo scheduleDo=new ScheduleDo();
			scheduleDo.setTrainNo(item.getTrainNo());
			scheduleDo.setDepartureTime(item.getDepartureTime());
			scheduleDo.setArrivalTime(item.getArrivalTime());			
			scheduleDoList.add(scheduleDo);
		});
		return scheduleDoList;
	}

}
