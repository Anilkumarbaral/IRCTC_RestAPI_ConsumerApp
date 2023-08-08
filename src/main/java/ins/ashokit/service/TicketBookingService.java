package ins.ashokit.service;

import ins.ashokit.bindings.Passenger;
import ins.ashokit.bindings.Ticket;

public interface TicketBookingService {

	   public Ticket bookTicket(Passenger passenger);
	   public Ticket getTicketbyNumb(Integer ticketNumb);
}
