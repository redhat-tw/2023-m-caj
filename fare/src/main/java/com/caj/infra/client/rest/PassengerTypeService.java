package com.caj.infra.client.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.PassengerTypeDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PassengerTypeService {

	/**
	 * masterfileUrl
	 */
	@Value("${caj.masterfile.url}")
	String masterfileUrl;
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;


	public BigDecimal getPassengerDiscount(String passengerType) {
		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder.append(masterfileUrl).append("/api/v1/passengerTypes/").append(passengerType)
				.toString();
		log.info("call masterfile api: {}", url);
		ResponseEntity<PassengerTypeDTO> response = restTemplate.getForEntity(url, PassengerTypeDTO.class);
		return response.getBody().getData();
	};
}
