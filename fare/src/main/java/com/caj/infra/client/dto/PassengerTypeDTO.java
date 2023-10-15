package com.caj.infra.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PassengerTypeDTO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 回應代碼
	 */
	private String code;

	/**
	 * 回應訊息
	 */
	private String message;

	/**
	 * 回傳資料
	 */
	private BigDecimal data;

	/**
	 * Trace ID
	 */
	private String traceId;
}
