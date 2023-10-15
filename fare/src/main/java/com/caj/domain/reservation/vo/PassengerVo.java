package com.caj.domain.reservation.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PassengerVo {

	private String type;
	
	private String trainNo;
	
	private String departure;
	
	private String departureTime;
	
	private String destination;
	
	private String arrivalTime;
	
	private String classCode;
}
