package com.caj.ui.dto;

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
public class FareRequestDTO {

	/**
	 * 出發站
	 */
	@Schema(description = "起站", defaultValue = "1")
	private String departure;
	
	/**
	 * 抵達站
	 */
	@Schema(description = "迄站", defaultValue = "12")
	private String destination;
	
	/**
	 * 廂等
	 */
	@Schema(description = "車廂等級; Y標準/J商務", defaultValue = "Y")
	private String classCode;
	
	/**
	 * 身份別
	 */
	@Schema(description = "身份別; 1全票/2孩童/3敬老/4愛心", defaultValue = "1")
	private String passengerType;
}
