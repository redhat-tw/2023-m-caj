package com.caj.domain.masterfile;

import java.math.BigDecimal;
import java.util.List;

public interface PassengerTypeRepository {

	/**
	 * Find Passenger Types
	 * @return
	 */
	public List<PassengerTypeDo> findPassengerTypes();
	
	
	/**
	 * Find Passenger Types
	 * @return
	 */
	public BigDecimal findPassengerDiscount(String passengerType);
}
