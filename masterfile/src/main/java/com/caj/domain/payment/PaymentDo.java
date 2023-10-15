package com.caj.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDo {

	/**
	 * 訂單編號
	 */
	private String pnr;
	
	/**
	 * 付款方式
	 */
	private String paymentMethod;
	
	/*
	 * 付款金額
	 */
	private int paymentAmt;
}
