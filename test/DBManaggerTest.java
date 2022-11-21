import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class DBManaggerTest {
    static DBManagger dbManagger;
    static String departureCity;
    static String arriveCity;

    @BeforeAll
    public static void init(){
        dbManagger = new DBManagger("MockupDBConnection");
        departureCity = "Berlin";
        arriveCity = "Roma";
    }

    @Test
    void searchingJourneysBasedCityes() {
        ArrayList<Journey> journey = dbManagger.journeysFromTo(departureCity, arriveCity);

        for (Journey j : journey) {
            Assertions.assertEquals(j.getFlights().get(0).departureCity, departureCity);
            Assertions.assertEquals(j.getFlights().get(j.getFlights().size()-1).arrivalCity, arriveCity);
        }

        Assertions.assertEquals(journey.size(), 3);
    }

    @Test
    void searchingJourneysBasedCityesAndDate() {
        Date departureDate = new Date(2022-11-21);
        Date arrivaleDate = null;

        ArrayList<Journey> journey = dbManagger.journeysStartAt(departureDate, departureCity, arrivaleDate, arriveCity);

        for (Journey j : journey) {
            Assertions.assertEquals(j.getFlights().get(0).departureCity, departureCity);
            Assertions.assertEquals(j.getFlights().get(0).departureDate, departureDate);
            Assertions.assertEquals(j.getFlights().get(j.getFlights().size()-1).arrivalCity, arriveCity);
        }

        Assertions.assertEquals(journey.size(), 2);
    }

    @Test
    void searchingJourneyBasedSearchObject() throws Exception {
        Date departureDate = new Date(2022-11-21);
        Date arrivaleDate = null;

        Search search = new Search(departureDate, departureCity, arrivaleDate, arriveCity);

        ArrayList<Journey> journey = dbManagger.searchJourneyBasedSearchObject(departureDate, departureCity, arrivaleDate, arriveCity);

        for (Journey j : journey) {
            Assertions.assertEquals(j.getFlights().get(0).departureCity, departureCity);
            Assertions.assertEquals(j.getFlights().get(0).departureDate, departureDate);
            Assertions.assertEquals(j.getFlights().get(j.getFlights().size()-1).arrivalCity, arriveCity);
        }

        Assertions.assertEquals(journey.size(), 2);
    }


}
