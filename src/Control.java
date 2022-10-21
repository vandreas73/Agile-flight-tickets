import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Control {
	private List<Journey> savedJourneys = new ArrayList<>();

	
	
	private String[] inputLine(String command, String exampleFormat) {
		System.out.println(command +
				"\nExample: " + exampleFormat);
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		sc.close();
		return line;
	}
	
	
	ArrayList<Journey> listJourneys(Date departureDate, String departureCity, String arrivalCity){
		//TODO: járatok keresése
		ArrayList<Journey> journeys = new ArrayList<>();
		Journey j1 = new Journey();
		j1.addFlight(new Flight(Date.valueOf("2022-10-21"), "Budapest", Date.valueOf("2022-10-21"), "Berlin"));
		journeys.add(j1);
		return journeys;
	}
	
	void saveJourney(Date departureDate, String departureCity, String arrivalCity, int id) throws Exception {
		ArrayList<Journey> journeys;
		journeys = listJourneys(departureDate, departureCity, arrivalCity);
		//String[] line2 = inputLine("Which journey do you want to save?", "1");
		savedJourneys.add(journeys.get(id));
		System.out.println("Saved succesfully.");
	}
	
	void getSavedJourneys() throws Exception {
		for (Journey journey : savedJourneys) {
			System.out.println(journey);
		}
	}
	
	
	

}

