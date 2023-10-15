package com.caj.domain.fare;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FareService {

	@Value("${caj.fare.price-per-mile}")
	private int pricePerMile;

	@Value("${caj.fare.business-class-rate}")
	private BigDecimal businessClassRate;

	/**
	 * calculate fare
	 * @return
	 */
	public int calcuteFare(int distance, BigDecimal passengerTypeDiscount, String classCode) {
		int result = "J".equals(classCode)
				? BigDecimal.valueOf(distance * pricePerMile).multiply(passengerTypeDiscount).multiply(businessClassRate).intValue()
				: BigDecimal.valueOf(distance * pricePerMile).multiply(passengerTypeDiscount).intValue();
		return result;
	}
	
	
}
