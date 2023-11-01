package com.caj.infra.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.caj.infra.client.dto.StationDTO;

@Service
public class StationService {

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

	public int getStationDistance(String departureId, String destinationId) {
		StringBuilder stringBuilder = new StringBuilder();
		String url = stringBuilder.append(masterfileUrl).append("/api/v1/stations/distance?departureId=")
				.append(departureId).append("&destinationId=").append(destinationId).toString();
		ResponseEntity<StationDTO> response = restTemplate.getForEntity(url, StationDTO.class);
		return response.getBody().getData();
	}
}
