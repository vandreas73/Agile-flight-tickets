import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Control {
	private List<Journey> savedJourneys = new ArrayList<>();

	private String[] inputLine(String command, String exampleFormat) {
		System.out.println(command + "\nExample: " + exampleFormat);
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		sc.close();
		return line;
	}

	ArrayList<Journey> listJourneys(Date departureDate, String departureCity, String arrivalCity) {
		// TODO: járatok keresése
		ArrayList<Journey> journeys = new ArrayList<>();
		Journey j1 = new Journey();
		j1.addFlight(new Flight(Date.valueOf("2022-10-21"), "Budapest", Date.valueOf("2022-10-21"), "Berlin"));
		journeys.add(j1);
		return journeys;
	}

	Boolean saveJourney(Date departureDate, String departureCity, String arrivalCity, int id) throws Exception {
		ArrayList<Journey> journeys;
		journeys = listJourneys(departureDate, departureCity, arrivalCity);
		// String[] line2 = inputLine("Which journey do you want to save?", "1");
		savedJourneys = getSavedJourneys();
		savedJourneys.add(journeys.get(id));
		if (persistJourneys(journeys))
			return true;
		else
			return false;
	}
	
	Boolean persistJourneys(ArrayList<Journey> journeys) {
		try {
			File f = new File("save.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(journeys);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	ArrayList<Journey> getSavedJourneys() throws Exception {
		try {
			FileInputStream fis = new FileInputStream("save.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Journey> woi=new ArrayList<>();
	        woi=(ArrayList<Journey>)ois.readObject();
	        return woi;
		} catch (Exception e) {
			System.out.println("Something went wrong.");
			return null;
		}
	}
	
	Boolean deleteSavedJourney(int index) throws Exception {
		var journeys = getSavedJourneys();
		try {
			journeys.remove(index);
			persistJourneys(journeys);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	void clearSavedJourneys() {
		var empty = new ArrayList<Journey>();
		persistJourneys(empty);
	}

}
