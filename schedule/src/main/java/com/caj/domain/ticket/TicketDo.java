package com.caj.domain.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDo {
	
	/**
	 * 訂位代號
	 */
	private String pnr;

	/**
	 * 車次號碼
	 */
	private String trainNo;

	/**
	 * 起站
	 */
	private String departure;
	
	/**
	 * 迄站
	 */
	private String destination;
	
	/**
	 * 出發時間 YYYY-MM-DD HH:MM
	 */
	private String departureTime;

	/**
	 * 抵達時間 YYYY-MM-DD HH:MM
	 */
	private String arrivalTime;

	/**
	 * 車廂
	 */
	private String car;
	
	/**
	 * 廂等 Y 標準 J 商務
	 */
	private String classCode;
	
	/**
	 * 座位
	 */
	private String seat;
	
	/**
	 * 旅客身份
	 */
	private String passengerType;
	
}
