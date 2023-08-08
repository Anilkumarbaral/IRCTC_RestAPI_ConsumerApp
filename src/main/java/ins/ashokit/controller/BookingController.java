package ins.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ins.ashokit.bindings.Passenger;
import ins.ashokit.bindings.Ticket;
import ins.ashokit.service.TicketBookingService;

@Controller
public class BookingController {
	
	@Autowired
	TicketBookingService service;
	
	@GetMapping("get-ticket")
	public String getTicket(@RequestParam Integer ticketNumb,Model model) {
		System.out.println(ticketNumb);
		Ticket ticket=service.getTicketbyNumb(ticketNumb);
		model.addAttribute("ticket",ticket);
		return "Ticket-Form";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		   model.addAttribute("ticket",new Ticket());
		return "Ticket-Form";
	}
	
	@PostMapping("book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger,Model model) {
		
		Ticket ticket=service.bookTicket(passenger);
		model.addAttribute("msg","Your Ticket booked with id: "+ticket.getTicketNumber())	;
		return "index";
	}
	
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger",new Passenger());
		return "index";
	}

}
