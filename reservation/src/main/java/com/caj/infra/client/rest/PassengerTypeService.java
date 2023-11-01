package com.caj.infra.client.rest;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.PassengerTypeDTO;

@Service
public class PassengerTypeService {
	
	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");

	/**
	 * masterfileUrl
	 */
	@Value("${caj.masterfile.url}")
	String masterfileUrl;
	
	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;

	public BigDecimal getPassengerDiscount(String passengerType) {
		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder.append(masterfileUrl).append("/api/v1/passengerTypes/").append(passengerType)
				.toString();
		log.info("call masterfile api: {}", url);
		ResponseEntity<PassengerTypeDTO> response = restTemplate.getForEntity(url, PassengerTypeDTO.class);
		return response.getBody().getData();
	};
}
