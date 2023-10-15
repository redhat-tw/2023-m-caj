package com.caj.domain.fare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FareDo {

	/**
	 * 出發站
	 */
	private String departure;
	
	/**
	 * 抵達站
	 */
	private String destination;
	
	/**
	 * 廂等
	 */
	private String classCode;
	
	/**
	 * 身份別
	 */
	private String passengerType;
	
	/**
	 * 票價
	 */
	private int fare;
	
}
