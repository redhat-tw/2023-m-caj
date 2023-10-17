package com.caj.infra.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.PaymentRequestDTO;
import com.caj.infra.client.dto.PaymentResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentService {

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
