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
public class PaymentRequestDTO {

	/**
	 * 訂單編號
	 */
	@Schema(description = "訂位號碼",defaultValue = "9527")
	private String pnr;
	
	/**
	 * 付款方式
	 */
	@Schema(description = "付款方式",defaultValue = "1")
	private String paymentMethod;
	
	/*
	 * 付款金額
	 */
	@Schema(description = "付款金額",defaultValue = "12000")
	private int paymentAmt;
}
