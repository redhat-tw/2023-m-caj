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
public class ScheduleVo {

	/**
	 * 車次號碼
	 */
    private String trainNo;
    
    /**
     * 出發時間
     */
    private String departureTime;
    
    /**
     * 抵達時間
     */
    private String arrivalTime;
    
}
