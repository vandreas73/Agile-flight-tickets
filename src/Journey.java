import java.io.Serializable;
import java.util.ArrayList;

public class Journey implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Flight> flights = new ArrayList<Flight>();
	
	public void addFlight(Flight f) {
		flights.add(f);
	}
	
	ArrayList<Flight> getFlights(){
		return flights;
	}

}
