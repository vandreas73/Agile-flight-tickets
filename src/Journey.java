import java.util.List;

public class Journey {
	private List<Flight> flights;
	
	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	
	public int transferCount() {
		return flights.size();
	}
	
}
