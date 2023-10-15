package com.caj.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.ticket.TicketDo;
import com.caj.domain.ticket.TicketRepository;
import com.caj.infra.repository.mapper.TicketDao;
import com.caj.infra.repository.po.TicketPo;


@Service
public class TicketRepositoryImpl implements TicketRepository {

	@Autowired
	TicketDao ticketDao;

	@Override
	public void saveTicket(TicketDo ticketDo) {
		ticketDao.save(TicketPo.builder()
				.pnr(ticketDo.getPnr())
				.trainNo(ticketDo.getTrainNo())
				.departure(ticketDo.getDeparture())
				.departureTime(ticketDo.getDepartureTime())
				.destination(ticketDo.getDestination())
				.arrivalTime(ticketDo.getArrivalTime())
				.passengerType(ticketDo.getPassengerType())
				.car(ticketDo.getCar())
				.seat(ticketDo.getSeat())
				.classCode(ticketDo.getClassCode())
				.build());
	}

}
