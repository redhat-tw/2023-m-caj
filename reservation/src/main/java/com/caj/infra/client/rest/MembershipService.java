package com.caj.infra.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.MembershipRequestDTO;
import com.caj.infra.client.dto.MembershipResponseDTO;

@Service
public class MembershipService {
	
	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");

	/**
	 * mebershipUrl
	 */
	@Value("${caj.mebership.url}")
	String mebershipUrl;
	
	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;

	public void createExpenseRecord(String memberType, String memberId, int amt) {

		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder.append(mebershipUrl).append("/api/v1/membership").toString();
		log.info("call mebership api: {}", url);
		restTemplate.postForEntity(url, 
				MembershipRequestDTO.builder()
				.memberType(memberType)
				.memberId(memberId)
				.paymentAmt(amt)
				.build(),
				MembershipResponseDTO.class);
	};
}
