package com.caj.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.membership.MembershipService;
import com.caj.domain.payment.PaymentService;
import com.caj.domain.reservation.ReservationDo;
import com.caj.domain.reservation.ReservationService;
import com.caj.domain.ticket.TicketService;

@Service
public class ReservationApplicationService {

	@Autowired
	PaymentService paymentService;

	@Autowired
	MembershipService membershipService;

	@Autowired
	ReservationService reservationService;

	@Autowired
	TicketService ticketService;
	

	public String execute(ReservationDo reservationDo) {

		// Payment
		paymentService.pay(reservationDo.getPnr(), reservationDo.getPayment().getPaymentMethod(),
				reservationDo.getPayment().getPaymentAmt());

		// Membership Accumulation
		membershipService.createExpenseRecord(reservationDo.getMembership().getMemberType(),
				reservationDo.getMembership().getMemberId(), reservationDo.getPayment().getPaymentAmt());

		// Create Passenger Name Record
		reservationService.createPNR(reservationDo);
		
		// Create Passengers
		reservationService.genPassengerInfo(reservationDo).forEach(item -> {
			
			// Create Ticket
			ticketService.createTickets(
					reservationDo.getPnr(),
					item.getType() , 
					item.getTrainNo(), 
					item.getDeparture(),
					item.getDepartureTime(),
					item.getDestination(),
					item.getArrivalTime(),
					item.getClassCode());
		});

		return reservationDo.getPnr();
	}
	
	
}
