import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JourneyData {
    private ArrayList<Flight> flights;

    public JourneyData(String departureDate, String departureCity, String arrivalDate, String arrivalCity) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        flights.add(new Flight(formatter.parse(departureDate), departureCity, formatter.parse(arrivalDate), arrivalCity));
    }

    public int getFlightNum() {
        return flights.size();
    }

    public Flight getFlight(int i) {
        return flights.get(i);
    }
}
