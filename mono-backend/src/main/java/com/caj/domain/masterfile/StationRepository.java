package com.caj.domain.masterfile;

import java.util.List;


public interface StationRepository {

	/**
	 * findStations
	 * @return
	 */
	public List<StationDo> findStations();
	
	/**
	 * findStationDistance
	 * @return
	 */
	public int findStationDistance(String departureId, String destinationID);
}