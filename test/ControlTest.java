import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlTest {
    Control control;

    @BeforeEach
    void setUp() {
        control = new Control();
    }


    @Test
    void saveJourney() {
        var j = new Journey();
        var f = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
        j.addFlight(f);
        control.saveJourney(j);
        ArrayList<Journey> savedJourneys = control.getSavedJourneys();
        var contains = false;
        for (Journey journey : savedJourneys) {
            for (Flight flight : journey.getFlights()) {
                if (flight.arrivalCity.equals(f.arrivalCity) && flight.arrivalDate.equals(f.arrivalDate)
                        && flight.departureCity.equals(f.departureCity)
                        && flight.departureDate.equals(f.departureDate)){
                    contains = true;
                }
            }
        }
        Assertions.assertTrue(contains);
    }

    @Test
    void getSavedJourneys() {
        var j = control.getSavedJourneys();
        Assertions.assertNotNull(j);
    }

    @Test
    void clearSavedJourneys() {
        control.clearSavedJourneys();
        var newSavedJourneys = control.getSavedJourneys();
        Assertions.assertTrue(newSavedJourneys.isEmpty());
    }

    @Test
    void persistentJourneyTest() {
        control.clearSavedJourneys();
        var j1 = new Journey();
        var f1 = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
        j1.addFlight(f1);
        control.saveJourney(j1);
        var j2 = new Journey();
        var f2 = new Flight("2022-11-09", "Bratislava", "2022-11-10", "Nairobi");
        j2.addFlight(f2);
        control.saveJourney(j2);

        var journeys = control.getSavedJourneys();
        assertEquals(journeys.get(0).getFlights().get(0).departureCity,
                j1.getFlights().get(0).departureCity);
        assertEquals(journeys.get(1).getFlights().get(0).arrivalCity,
                j2.getFlights().get(0).arrivalCity);
    }

    @Test
    void deleteSavedJourney() {
        control.clearSavedJourneys();
        var j = new Journey();
        var f = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
        j.addFlight(f);
        control.saveJourney(j);
        Assertions.assertFalse(control.getSavedJourneys().isEmpty());

        control.deleteSavedJourney(0);
        Assertions.assertTrue(control.getSavedJourneys().isEmpty());

    }


    @Test
    void deleteSavedJourneyIndexOutOfBound() {
        control.clearSavedJourneys();
        var j = new Journey();
        var f = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
        j.addFlight(f);
        control.saveJourney(j);
        Assertions.assertFalse(control.getSavedJourneys().isEmpty());


        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> control.deleteSavedJourney(1));
    }


}
