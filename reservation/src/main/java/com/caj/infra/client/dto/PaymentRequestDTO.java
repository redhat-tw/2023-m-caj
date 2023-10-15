package com.caj.infra.client.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentRequestDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

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