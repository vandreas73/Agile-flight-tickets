import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class Control {
	private ArrayList<Journey> savedJourneys = new ArrayList<>();

	private final DataBase dataBase = new DataBase();
	public DataBase getDataBase() { return this.dataBase; };

	ArrayList<Journey> listJourneys(Date departureDate, String departureCity, String arrivalCity) throws ParseException {
		JourneySearcher searcher = new JourneySearcher();
		return searcher.getJourneys(departureDate, departureCity, arrivalCity);
	}

	Boolean saveJourney(Date departureDate, String departureCity, String arrivalCity, int id) throws Exception {
		ArrayList<Journey> journeys = listJourneys(departureDate, departureCity, arrivalCity);
		// String[] line2 = inputLine("Which journey do you want to save?", "1");
		savedJourneys = getSavedJourneys();
		savedJourneys.add(journeys.get(id));
		if (persistJourneys(savedJourneys))
			return true;
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
			return new ArrayList<>();
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

	ArrayList<String[]> sortFlightsByDepartureCity(String departureCity) {
		var out = new ArrayList<String[]>();

		dataBase.data.forEach(d -> {
			if (d[1].equals(departureCity))
				out.add(d);
		});

		return out;
	}

	ArrayList<String[]> sortFlightsByArrivalCity(String arrivalCity) {
		var out = new ArrayList<String[]>();

		dataBase.data.forEach(d -> {
			if (d[3].equals(arrivalCity))
				out.add(d);
		});

		return out;
	}

	ArrayList<String[]> sortFlightsByPrice(String[] args) {
		var out = new ArrayList<String[]>();

		dataBase.data.forEach( d -> {
			if (d[1].equals(args[1]))
				out.add(d);
		});

		out.sort((c1, c2) -> {
			if (c1[4].equals(c2[4])) return 0;
			else if (Integer.parseInt(c1[4]) > Integer.parseInt(c2[4])) return 1;
			else return -1;
		});

		return out;
	}
}
