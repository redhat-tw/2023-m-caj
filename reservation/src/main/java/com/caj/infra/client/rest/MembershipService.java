package com.caj.infra.client.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.MembershipRequestDTO;
import com.caj.infra.client.dto.MembershipResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MembershipService {

	/**
	 * mebershipUrl
	 */
	@Value("${caj.mebership.url}")
	String mebershipUrl;

	public void createExpenseRecord(String memberType, String memberId, int amt) {

		RestTemplate restTemplate = new RestTemplate();
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
