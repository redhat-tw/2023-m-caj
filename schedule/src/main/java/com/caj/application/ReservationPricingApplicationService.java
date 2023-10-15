package com.caj.application;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.fare.FareService;
import com.caj.domain.masterfile.PassengerTypeService;
import com.caj.domain.masterfile.StationService;
import com.caj.domain.reservation.ReservationDo;
import com.caj.domain.reservation.ReservationService;


@Service
public class ReservationPricingApplicationService {

	@Autowired
	ReservationService reservationService;

	@Autowired
	PassengerTypeService passengerTypeService;
	
	@Autowired
	StationService stationService;
	
	@Autowired
	FareService fareService;
	
	public int execute(ReservationDo reservationDo) {
		// Create Passengers
		return reservationService.genPassengerInfo(reservationDo).stream().map(item -> {
			// Get Distance
			int distance =stationService.getStationDistance(item.getDeparture(), item.getDestination());
			
			// Get Passenger Discount
			BigDecimal discount= passengerTypeService.getPassengerDiscount(item.getType());
			
			// Calculate Price
			return fareService.calcuteFare(distance, discount, item.getClassCode());
			
		}).mapToInt(Integer::intValue).sum();
	}
}
