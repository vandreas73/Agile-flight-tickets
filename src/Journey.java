import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Journey {
	private List<Flight> flights = new ArrayList<>();
	
	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	
	public int transferCount() {
		return flights.size();
	}
	
	@Override
	public String toString() {
		String out = "";
		for (Flight flight : flights) {
			out.concat(flight.toString());
		}
		return out;
	}
}
