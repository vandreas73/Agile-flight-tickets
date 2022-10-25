import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class JourneySearcher {
    private DataBase dataBase;

    public JourneySearcher() {
        dataBase = new DataBase();
    }

    public ArrayList<Journey> getJourneys(Date departureDate, String departureCity, String arrivalCity) throws ParseException {
        JourneyDataSet journeyDataSet = dataBase.SelectFunctionWithParams(departureDate, departureCity, arrivalCity);

        ArrayList<Journey> journeys = new ArrayList<Journey>();

        for (int i = 0;  i < journeyDataSet.getJourneyNum(); i++) {
            Journey ji = new Journey();
            JourneyData journeyData = journeyDataSet.getJourney(i);

            for (int j = 0; j < journeyData.getFlightNum(); j++) {
                ji.addFlight(journeyData.getFlight(j));
            }

            journeys.add(ji);
        }

        return journeys;
    }

}
