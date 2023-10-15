package com.caj.domain.ticket;

public interface TicketRepository {

	/**
	 * Create Tickets
	 * 
	 * @return
	 */
	public void saveTicket(TicketDo ticketDos);

}
