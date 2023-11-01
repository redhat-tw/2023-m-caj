package com.caj.infra.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.PaymentRequestDTO;
import com.caj.infra.client.dto.PaymentResponseDTO;

@Service
public class PaymentService {
	
	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");

	/**
	 * paymentUrl
	 */
	@Value("${caj.payment.url}")
	String paymentUrl;
	
	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;

	public void pay(String pnr, String method,int amt) {
		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder.append(paymentUrl).append("/api/v1/payments").toString();
		log.info("call payment api: {}", url);
		restTemplate.postForEntity(url, 
				PaymentRequestDTO.builder()
				.pnr(pnr)
				.paymentMethod(method)
				.paymentAmt(amt)
				.build(),
				PaymentResponseDTO.class);
	}
}
