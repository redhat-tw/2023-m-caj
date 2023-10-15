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
public class ReservationRequestDTO {

	/**
	 * 服務類別 1. 自由 2. 對號 3. 取票
	 */
	@Schema(description = "服務類別; 1自由/2對號", defaultValue = "1")
	private String serviceType;

	/**
	 * 1.單程 2.來回
	 */
	@Schema(description = "來回票; 1單程/2來回", defaultValue = "1")
	private String roundTrip;

	/**
	 * 旅客
	 */
	@Schema(description = "旅客清單")
	private List<Passenger> passengers;

	/**
	 * 出發站
	 */
	@Schema(description = "出發站", defaultValue = "1")
	private String departure;

	/**
	 * 抵達站
	 */
	@Schema(description = "抵達站", defaultValue = "12")
	private String destination;

	/**
	 * 出發車次
	 */
	@Schema(description = "出發車次")
	private TrainInfo outbound;

	/**
	 * 回程車次
	 */
	@Schema(description = "回程車次")
	private TrainInfo inbound;

	/**
	 * 會員身份別 1 無 , 2 企業 , 3 XGO
	 */
	@Schema(description = "會員身份別", defaultValue = "2")
	private String memberType;

	/**
	 * 會員 ID
	 */
	@Schema(description = "會員ID", defaultValue = "28422255")
	private String memberId;

	/**
	 * 付款方式 1 現金
	 */
	@Schema(description = "付款方式;1現金", defaultValue = "1")
	private String paymentMethod;

	/**
	 * 付款金額
	 */
	@Schema(description = "付款金額", defaultValue = "20000")
	private int paymentAmt;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	@Schema(description = "旅客")
	public static class Passenger {
		/**
		 * 旅客身份別
		 */
		@Schema(description = "旅客身份別", defaultValue = "1")
		private String type;

		/**
		 * 張數
		 */
		@Schema(description = "張數", defaultValue = "1")
		private int amt;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonInclude(Include.NON_NULL)
	@Schema(description = "車次資訊")
	public static class TrainInfo {
		/**
		 * 車次號碼
		 */
		@Schema(description = "車次號碼", defaultValue = "1001")
		private String trainNo;

		/**
		 * 出發時間 YYYY-MM-DD HH:MM
		 */
		@Schema(description = "出發時間; YYYY-MM-DD-HH:MM", defaultValue = "2023-01-01 08:30")
		private String departureTime;

		/**
		 * 抵達時間 YYYY-MM-DD HH:MM
		 */
		@Schema(description = "抵達時間; YYYY-MM-DD-HH:MM", defaultValue = "2023-01-01 09:30")
		private String arrivalTime;

		/**
		 * 廂等 Y 標準 J 商務
		 */
		@Schema(description = "廂等;Y標準/J商務", defaultValue = "Y")
		private String classCode;
	}

}
