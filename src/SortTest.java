import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class SortTest {

    Sort sort;

    @BeforeEach
    void setUp() {
        try {
            sort = new Sort("MockupDBConnection");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void isDatabaseNull() {
        Assertions.assertNull(sort.db.data);
    }

    @Test
    void isDatabaseEmpty() {
        sort.db.setUpInitialData();
        Assertions.assertFalse(sort.isDatabaseEmpty());
    }

    @Test
    void testSortingByPrice() {

    }

    @Test
    void testSortingByDeparture() {
        var sorted = sort.sortDatabaseByDeparture("Budapest");
        AtomicBoolean isCorrect = new AtomicBoolean(true);
        sorted.forEach(flight -> {
            if (!flight.departureCity.equals("Budapest")) {
                isCorrect.set(false);
            }
        });
        Assertions.assertTrue(isCorrect.get());
    }
}
