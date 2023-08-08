package ins.ashokit.bindings;
import lombok.Data;
@Data
public class Ticket {	
	private String trainNumber;
	private String name;
	private String from;
	private String to;
	private String doj;
	private Integer ticketNumber;
	private String status;
	private String ticketCost;
}
