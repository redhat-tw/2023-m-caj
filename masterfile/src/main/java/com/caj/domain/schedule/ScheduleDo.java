package com.caj.domain.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDo {

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
