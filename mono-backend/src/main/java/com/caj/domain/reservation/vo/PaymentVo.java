package com.caj.domain.reservation.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PaymentVo {

	/**
	 * 付款方式
	 */
	private String paymentMethod;
	
	/*
	 * 付款金額
	 */
	private int paymentAmt;
}
