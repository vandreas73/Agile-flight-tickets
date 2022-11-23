import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class SortTest {

    static Sort sort;

    @BeforeAll
    static void setUp() {
        try {
            sort = new Sort("MockupDBConnection");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    void setUpBeforeAll() {
        sort.db.data = new ArrayList<>();
    }

    @Test
    void isDatabaseNull() {
        Assertions.assertNull(sort.db.data);
    }

    @Test
    void isDatabaseNotEmpty() {
        sort.db.setUpInitialData();
        Assertions.assertFalse(sort.isDatabaseEmpty());
    }

    @Test
    void testSortingByPrice() {
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "B", 4));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "B", 1));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "B", 3));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "B", 2));

        sort.sortDatabaseByPrice();

        Assertions.assertEquals(1, sort.db.data.get(0).price);
        Assertions.assertEquals(2, sort.db.data.get(1).price);
        Assertions.assertEquals(3, sort.db.data.get(2).price);
        Assertions.assertEquals(4, sort.db.data.get(3).price);
    }

    @Test
    void testSortingByDeparture() {
        sort.db.addData(new Flight(new Date(2022-10-10), "B", new Date(2022-10-10), "A", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "D", new Date(2022-10-10), "A", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "A", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "C", new Date(2022-10-10), "A", 0));

        sort.sortDatabaseByDeparture();

        Assertions.assertEquals("A", sort.db.data.get(0).departureCity);
        Assertions.assertEquals("B", sort.db.data.get(1).departureCity);
        Assertions.assertEquals("C", sort.db.data.get(2).departureCity);
        Assertions.assertEquals("D", sort.db.data.get(3).departureCity);
    }

    @Test
    void testSortingByArrival() {
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "X", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "Z", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "Y", 0));
        sort.db.addData(new Flight(new Date(2022-10-10), "A", new Date(2022-10-10), "W", 0));

        sort.sortDatabaseByArrival();

        Assertions.assertEquals("W", sort.db.data.get(0).arrivalCity);
        Assertions.assertEquals("X", sort.db.data.get(1).arrivalCity);
        Assertions.assertEquals("Y", sort.db.data.get(2).arrivalCity);
        Assertions.assertEquals("Z", sort.db.data.get(3).arrivalCity);
    }
}
