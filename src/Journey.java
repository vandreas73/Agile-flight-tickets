import java.util.ArrayList;

public class Journey {
	private ArrayList<Flight> flights = new ArrayList();
	
	public void addFlight(Flight f) {
		flights.add(f);
	}
	
	ArrayList<Flight> getFlights(){
		return flights;
	}

}
