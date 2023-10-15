package com.caj.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.reservation.ReservationDo;
import com.caj.domain.reservation.ReservationService;
import com.caj.infra.client.rest.FareService;

@Service
public class ReservationPricingApplicationService {

	@Autowired
	ReservationService reservationService;

	@Autowired
	FareService fareService;

	public int execute(ReservationDo reservationDo) {
		// Create Passengers
		return reservationService.genPassengerInfo(reservationDo).stream().map(item -> {
			// Calculate Price
			return fareService.calcuteFare(item.getDeparture(), item.getDestination(), item.getClassCode(),
					item.getType());
		}).mapToInt(Integer::intValue).sum();
	}
}
