package ins.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ins.ashokit.bindings.Passenger;
import ins.ashokit.bindings.Ticket;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	private String BOOK_TICKET_URL="http://localhost:9090/ticket";
	private String GET_TICKET_URL="http://localhost:9090/ticket/{ticketNumb}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {	
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket>responseEntity=rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket=responseEntity.getBody();
		
		return ticket;
	}

	@Override
	public Ticket getTicketbyNumb(Integer ticketNumb) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket>responseEntity=rt.getForEntity(GET_TICKET_URL, Ticket.class,ticketNumb);
		Ticket ticket=responseEntity.getBody();
		return ticket;
	}

}
