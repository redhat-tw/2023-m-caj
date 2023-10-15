package com.caj.ui.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class GenericResponseDTO {
	
	/**
	 * 回應代碼
	 */
	@Schema(description = "回應代碼")
	private String code;

	/**
	 * 回應訊息
	 */
	@Schema(description = "回應訊息")
	private String message;

	/**
	 * 回傳資料
	 */
	@Schema(description = "回傳資料")
	private Object data;

	/**
	 * Trace ID
	 */
	@Schema(description = "Trace ID")
	private String traceId;
}
