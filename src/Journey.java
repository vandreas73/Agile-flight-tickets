import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

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
		var out = new ArrayList<>();
		StringJoiner flightJoiner = new StringJoiner(", ");
		for (int i = 0; i < flights.size(); ++i) {
			flightJoiner.add(i + ".\t" + flights.get(i).toString());
		}
		return flightJoiner.toString();
	}
}
