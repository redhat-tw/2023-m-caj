package com.caj.infra.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO implements Serializable {

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
	 * Trace ID
	 */
	private String traceId;

}
