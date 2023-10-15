package com.caj.infra.repository.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class PaymentPo {

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	/**
	 * 訂單編號
	 */
	@Column(name = "PNR")
	private String pnr;

	/**
	 * 付款方式
	 */
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;

	/*
	 * 付款金額
	 */
	@Column(name = "amt")
	private int amt;
}
