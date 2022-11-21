import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SearchTest {

    @Test
    void searchInitial() throws Exception {
        Date departureDate = new Date(2022-11-02);
        Date arrivalDate = new Date(2022-11-03);
        String departureCity = "Budapest";
        String arrivalCity = "Roma";

        Search search = new Search(departureDate, departureCity, arrivalDate, arrivalCity);

        var sameValues = false;
        if (search.getDepartureDate() == departureDate &&
                search.getDepartureCity() == departureCity &&
                search.getArrivalDate() == arrivalDate &&
                search.getArrivalCity() == arrivalCity) sameValues = true;

        Assertions.assertTrue(sameValues);
    }

    @Test
    void searchInitialWithNullDate() {
        Date Date1 = null;
        Date Date2 = null;
        String departureCity = "Budapest";
        String arrivalCity = "Roma";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Search search = new Search(Date1, arrivalCity, Date2, departureCity);
        });

        assertEquals("Both date are null", exception.getMessage());
    }

    @Test
    void searchInitialWithNullCity() {
        Date Date1 = new Date(2022-11-02);
        Date Date2 = new Date(2022-11-03);
        String departureCity = null;
        String arrivalCity = "Roma";

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Search search = new Search(Date1, arrivalCity, Date2, departureCity);
        });

        assertEquals("Invalid city parameter", exception.getMessage());
    }

}