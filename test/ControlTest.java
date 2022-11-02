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
		j.addFlight(new Flight("2022-11-02", "Budapest", "2022-11-03", "Paris"));
		control.saveJourney(j);
		ArrayList<Journey> savedJourneys = control.getSavedJourneys();
		Assertions.assertTrue(savedJourneys.contains(j));
		
	}

}
