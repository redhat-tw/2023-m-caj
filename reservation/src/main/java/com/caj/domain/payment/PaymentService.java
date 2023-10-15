package com.caj.domain.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	/**
	 * membershipRepository
	 */
	@Autowired
	PaymentRepository paymentRepository;

	/**
	 * pay
	 * 
	 * @return
	 */
	public void pay(String pnr, String paymentMethod, int amt) {
		paymentRepository.createPayRecord(pnr, paymentMethod, amt);
	}
}
