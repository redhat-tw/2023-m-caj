package com.caj.infra.repository.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCHEDULE")
public class SchedulePo {

	/**
	 * 車次號碼
	 */
	@Id
	@Column(name = "TRAIN_NO")
    private String trainNo;
    
    /**
     * 出發時間
     */
	@Column(name = "DEPARTURE_TIME")
    private String departureTime;
    
    /**
     * 抵達時間
     */
	@Column(name = "ARRIVAL_TIME")
    private String arrivalTime;
}
