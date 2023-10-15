package com.caj.ui.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caj.domain.reservation.ReservationDo;
import com.caj.domain.reservation.vo.MembershipVo;
import com.caj.domain.reservation.vo.PassengerVo;
import com.caj.domain.reservation.vo.PaymentVo;
import com.caj.domain.reservation.vo.ScheduleVo;
import com.caj.ui.dto.ReservationRequestDTO;


@Service
public class ReservationConverter {

	public ReservationDo toDo(ReservationRequestDTO reservationRequestDTO) {
		// Passenger
		List<PassengerVo> passengerVos=new ArrayList<>();
		reservationRequestDTO.getPassengers().forEach(item -> {
			for (int i = 1; i <= item.getAmt(); i++) {
			passengerVos.add(PassengerVo.builder()
					.type(item.getType())
					.build());
			}
		});
		
		// Payment
		PaymentVo paymentVo=PaymentVo.builder()
				.paymentMethod(reservationRequestDTO.getPaymentMethod())
				.paymentAmt(reservationRequestDTO.getPaymentAmt())
				.build();
		
		// Membership 
		MembershipVo membershipVo=MembershipVo.builder()
				.memberType(reservationRequestDTO.getMemberType())
				.memberId(reservationRequestDTO.getMemberId())
				.build();
		
		// Inbound
		ScheduleVo inbound=ScheduleVo.builder()
				.trainNo(reservationRequestDTO.getInbound().getTrainNo())
				.departureTime(reservationRequestDTO.getInbound().getDepartureTime())
				.arrivalTime(reservationRequestDTO.getInbound().getArrivalTime())
				.build();
		String inboundClass=reservationRequestDTO.getInbound().getClassCode();
		
		// Outbound
		ScheduleVo outbound=ScheduleVo.builder()
				.trainNo(reservationRequestDTO.getOutbound().getTrainNo())
				.departureTime(reservationRequestDTO.getOutbound().getDepartureTime())
				.arrivalTime(reservationRequestDTO.getOutbound().getArrivalTime())
				.build();
		String outboundClass=reservationRequestDTO.getOutbound().getClassCode();
		

		return ReservationDo.builder()
				.serviceTpye(reservationRequestDTO.getServiceType())
				.departure(reservationRequestDTO.getDeparture())
				.destination(reservationRequestDTO.getDestination())
				.roundTrip(reservationRequestDTO.getRoundTrip())
				.passengers(passengerVos)
				.payment(paymentVo)
				.membership(membershipVo)
				.inboundClass(inboundClass)
				.outboundClass(outboundClass)
				.inbound(inbound)
				.outbound(outbound)
				.build();
				
				
	}
}
