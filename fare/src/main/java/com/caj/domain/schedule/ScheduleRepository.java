package com.caj.domain.schedule;

import java.util.List;

public interface ScheduleRepository {

	
	/**
	 * Find Schedules
	 * @return
	 */
	public List<ScheduleDo> findSchedules();
	
	
}
