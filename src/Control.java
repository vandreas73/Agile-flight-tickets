import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Control {
	
	boolean saveJourney(Journey j) {
		try{
			ArrayList<Journey> savedJourneys;
			try {
				savedJourneys = getSavedJourneys();
			} catch (Exception e) {
				System.out.println("getsavedjourneys");
				savedJourneys = new ArrayList<>();
			} 
			savedJourneys.add(j);
			persistJourneys(savedJourneys);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	
	ArrayList<Journey> getSavedJourneys(){
		try {
			var f = new File("save.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Journey> woi=new ArrayList<>();
	        woi=(ArrayList<Journey>)ois.readObject();
	        return woi;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	ArrayList<Journey> listJourneys(Date departureDate, String departureCity, String arrivalCity) {
		//TODO
		ArrayList<Journey> journeys = new ArrayList<>();
		var journey = new Journey();
		journey.addFlight(new Flight(departureDate, departureCity, departureDate, arrivalCity));
		journeys.add(journey);
		return journeys;
	}

	void clearSavedJourneys() {
		persistJourneys(new ArrayList<Journey>());
	}

	public void deleteSavedJourney(int index) throws IndexOutOfBoundsException {
		var savedJourneys = getSavedJourneys();
		try {
			savedJourneys.remove(index);
			persistJourneys(savedJourneys);
		} catch (IndexOutOfBoundsException e) {
			throw e;
		}
	}

}
