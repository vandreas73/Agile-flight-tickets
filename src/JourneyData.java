import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JourneyData {
    private ArrayList<Flight> flights;

    // itt sem volt létrehozva a változó és nagy MM-et ír a doksi
    public JourneyData(String departureDate, String departureCity, String arrivalDate, String arrivalCity) throws ParseException {
        flights = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        var asd = formatter.parse(departureDate);
        flights.add(new Flight(formatter.parse(departureDate), departureCity, formatter.parse(arrivalDate), arrivalCity));
    }

    public int getFlightNum() {
        return flights.size();
    }

    public Flight getFlight(int i) {
        return flights.get(i);
    }
}
