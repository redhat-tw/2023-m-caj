package com.caj.domain.reservation;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.reservation.vo.PassengerVo;
import com.caj.domain.reservation.vo.ScheduleVo;
import com.caj.infra.repository.ReservationRepositoryImpl;

@Service
public class ReservationService {

	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");
	
	@Autowired
	ReservationRepositoryImpl reservationRepositoryImpl;

	/**
	 * 產生訂位代號
	 */
	public void createPNR(ReservationDo reservationDo) {
		reservationDo.setPnr(UUID.randomUUID().toString());
		reservationRepositoryImpl.savePnr(reservationDo.getPnr());
	}

	/**
	 * 產生訂位中的所有旅客資訊
	 * 
	 * @param reservationDo
	 */
	public List<PassengerVo> genPassengerInfo(ReservationDo reservationDo) {
		log.info("xxxxxx {}",reservationDo.getPassengers().size());
		List<PassengerVo> passengers = new ArrayList<>();
		String serviceType = reservationDo.getServiceTpye();
		String roundTrip = reservationDo.getRoundTrip();
		ScheduleVo outbound = reservationDo.getOutbound();
		ScheduleVo inbound = reservationDo.getInbound();
		reservationDo.getPassengers().forEach(item -> {
			item.setDeparture(reservationDo.getDeparture());
			item.setDestination(reservationDo.getDestination());
			// Free
			if ("1".equals(serviceType)) {
				item.setClassCode("K");
				// Reserved
			} else if ("2".equals(serviceType)) {
				item.setTrainNo(outbound.getTrainNo());
				item.setClassCode(reservationDo.getOutboundClass());
				item.setDepartureTime(outbound.getDepartureTime());
				item.setArrivalTime(outbound.getArrivalTime());
			}
			passengers.add(item);
			// Roundtrip
			if ("2".equals(roundTrip)) {
				passengers.add(PassengerVo.builder()
						.trainNo(inbound.getTrainNo())
						.type(item.getType())
						.departure(item.getDestination())
						.departureTime(inbound.getDepartureTime())
						.destination(item.getDeparture())
						.arrivalTime(inbound.getArrivalTime())
						.classCode(reservationDo.getInboundClass()!=null ? reservationDo.getInboundClass(): "K")
						.build());
			}
		});
		
		return passengers;

	}

}
