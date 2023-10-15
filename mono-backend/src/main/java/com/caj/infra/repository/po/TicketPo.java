package com.caj.infra.repository.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TICKET")
public class TicketPo {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	/**
	 * 訂位代號
	 */
	@Column(name = "PNR")
	private String pnr;

	/**
	 * 車次號碼
	 */
	@Column(name = "TRAIN_NO")
	private String trainNo;

	/**
	 * 起站
	 */
	@Column(name = "DEPARTURE")
	private String departure;

	/**
	 * 出發時間 YYYY-MM-DD-HH:MM
	 */
	@Column(name = "DEPARTURE_TIME")
	private String departureTime;
	
	/**
	 * 迄站
	 */
	@Column(name = "DESTINATION")
	private String destination;

	/**
	 * 抵達時間 YYYY-MM-DD-HH:MM
	 */
	@Column(name = "ARRIVAL_TIME")
	private String arrivalTime;

	
	/**
	 * 車廂
	 */
	@Column(name = "CAR")
	private String car;
	
	
	/**
	 * 座位
	 */
	@Column(name = "SEAT")
	private String seat;
	
	/**
	 * 廂等 Y 標準 J 商務
	 */
	@Column(name = "CLASS_CODE")
	private String classCode;

	/**
	 * 旅客身份
	 */
	@Column(name = "PASSENGER_TYPE")
	private String passengerType;

}
