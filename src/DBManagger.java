import java.util.ArrayList;
import java.util.Date;

public class DBManagger {
    MockupDB mockupDB;

    DBManagger(String dataBaseConnection) {
        mockupDB = new MockupDB(dataBaseConnection);
    }

    public ArrayList<Journey> journeysFromTo(String departureCity, String arriveCity) {
        ArrayList<Journey> result = new ArrayList<>();

        Journey[] journeys = mockupDB.selectJourneysFromTo(departureCity, arriveCity);
        for (Journey j : journeys) result.add(j);

        return result;
    }

    public ArrayList<Journey> journeysStartAt(Date departureDate, String departureCity, Date arriveDate, String arriveCity) {
        ArrayList<Journey> result = new ArrayList<>();

        Journey[] journeys = mockupDB.selectJourneysFromToAt(departureCity, departureDate, arriveCity, arriveDate);
        for (Journey j : journeys) result.add(j);

        return result;
    }

    public ArrayList<Journey> searchJourneyBasedSearchObject(Date departureDate, String departureCity, Date arrivaleDate, String arriveCity) {
        return journeysStartAt(departureDate, departureCity, arrivaleDate, arriveCity);
    }
}
