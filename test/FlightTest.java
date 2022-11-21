import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightTest {
    Flight f;

    @BeforeEach
    void setUp() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        var departureDate = new Date();
        try {
            departureDate = ft.parse("2022-11-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var arrivalDate = new Date();
        try {
            arrivalDate = ft.parse("2022-11-03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        f = new Flight(departureDate, "Budapest", arrivalDate, "Paris");
    }

    @Test
    void testToString() {
        String s = f.toString();
        System.out.println(s);
        Assertions.assertTrue(s.contains("Budapest"));
        Assertions.assertTrue(s.contains("Paris"));
        Assertions.assertTrue(s.contains("2022"));
    }

    @Test
    void testConstructor() {
        f = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
        testToString();
    }

}
