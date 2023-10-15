package com.caj.domain.masterfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDo {

	/**
	 * stationId
	 */
	private String stationId;	

	/**
	 * stationName
	 */
	private String stationName;
	
	/**
	 * stationEngName
	 */
	private String stationEngName;
	
	/**
	 * stationCode
	 */
	private String stationCode;
	
	/**
	 * stationOrder
	 */
	private String stationOrder;
	
	/**
	 * stationDistance
	 */
	private int stationDistance;
	
}
