package com.caj.infra.client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.FareDTO;

@Service
public class FareService {

	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");
	
	/**
	 * fareUrl
	 */
	@Value("${caj.fare.url}")
	String fareUrl;
	
	
	/**
	 * restTemplate
	 */
	@Autowired
	RestTemplate restTemplate;
	
	
	public int calcuteFare(String departure,String destination,String classCode,String passengerType){
		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder
				.append(fareUrl)
				.append("/api/v1/fare?departure=")
				.append(departure)
				.append("&destination=")
				.append(destination)
				.append("&classCode=")
				.append(classCode)
				.append("&passengerType=")
				.append(passengerType)
				.toString();
		log.info("call masterfile api: {}", url);
		ResponseEntity<FareDTO> response = restTemplate.getForEntity(url, FareDTO.class);
		return response.getBody().getData();
	};
}
