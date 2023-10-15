package com.caj.domain.ticket;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	/**
	 * 建立車票
	 */
	public void createTickets(
			String pnr, 
			String passengerType, 
			String trainNo,
			String departure, 
			String departureTime,
			String destination,
			String arrivalTime,
			String classCode) {
			TicketDo ticketDo=TicketDo.builder()
				.pnr(pnr)
				.trainNo(trainNo)
				.passengerType(passengerType)
				.departure(departure)
				.departureTime(departureTime)
				.destination(destination)
				.arrivalTime(arrivalTime)
				.classCode(classCode)
				.build();
			this.seatAssignment(ticketDo);
		ticketRepository.saveTicket(ticketDo);
	}

	/**
	 * 分派座位
	 * 
	 * @param ticketDo
	 * @return
	 */
	private TicketDo seatAssignment(TicketDo ticketDo) {
		// 創建一個Random 物件
		Random random = new Random();
		// 標準車廂
		String[] standardClass = { "1", "2", "3", "4", "5", "7", "8", "9", "10" };
		// 派標準車廂
		if ("Y".equals(ticketDo.getClassCode())) {
			int randomIndex = random.nextInt(standardClass.length);
			String randomStandardClass = standardClass[randomIndex];
			ticketDo.setCar(randomStandardClass);
			// 派商務車廂
		} else if ("J".equals(ticketDo.getClassCode())) {
			ticketDo.setCar("6");
		}
		// 派座位
		int randomSeat = random.nextInt(66) + 1;
		ticketDo.setSeat(String.valueOf(randomSeat));
		return ticketDo;
	}

}
