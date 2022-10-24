import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class Journey implements Serializable{
	private static final long serialVersionUID = 1L;
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
			flightJoiner.add("\t" + i + ". flight\t" + flights.get(i).toString());
		}
		return flightJoiner.toString();
	}
}
