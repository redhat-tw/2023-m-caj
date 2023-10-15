package com.caj.ui.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class ReservationResponseDTO {
	
	/**
	 * 車票清單
	 */
	@Schema(description = "車票清單")
	private List<Ticket> tickets;
	
	/**
	 * 車票資訊
	 */
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	@Schema(description = "車票")
	class Ticket{
		
		/**
		 *日期 YYYY-MM-DD
		 */
		private String boardingDate;
		
		/**
		 * 出發時間 HH:MM
		 */
		private String departureTime;
		
		/**
		 * 抵達時間 HH:MM
		 */
		private String arrivaleTime;
		
		/**
		 * 車次號碼
		 */
		private String trainNo;
		
		/**
		 * 車廂
		 */
		private String car;
		
		/**
		 * 座位
		 */
		private String seat;
		
	}

}
