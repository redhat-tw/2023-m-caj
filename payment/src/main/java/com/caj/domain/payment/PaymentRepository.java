package com.caj.domain.payment;

public interface PaymentRepository {

	/**
	 * 支付
	 * @param memberType
	 * @param memberId
	 * @param amt
	 */
	public void createPayRecord(String pnr, String paymentMethod, int amt);
	
}
