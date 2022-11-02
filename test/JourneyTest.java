import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JourneyTest {
	Journey journey;
	
	@BeforeEach
	void setUp() {
		journey = new Journey();
	}

	@Test
	void addFlight() {
		Flight f = new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris");
		journey.addFlight(f);
		var flights = journey.getFlights();
		Assertions.assertTrue(flights.contains(f));
	}
	
	

}
