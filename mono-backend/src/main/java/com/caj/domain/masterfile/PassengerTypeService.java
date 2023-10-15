package com.caj.domain.masterfile;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerTypeService {

	/**
	 * stationRepository
	 */
	@Autowired
	PassengerTypeRepository passengerTypeRepository;

	/**
	 * getStationDoList
	 * 
	 * @return
	 */
	public List<PassengerTypeDo> getPassengerTypeDoList() {
		return passengerTypeRepository.findPassengerTypes();
	}

	/**
	 * getPassengerDiscount
	 * @param passengerType
	 * @return
	 */
	public BigDecimal getPassengerDiscount(String passengerType) {
		return passengerTypeRepository.findPassengerDiscount(passengerType);
	}
}
