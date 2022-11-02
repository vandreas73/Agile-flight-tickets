import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Control {
	
	public boolean saveJourney(Journey j) {
		try{
			var savedJourneys = getSavedJourneys();
			savedJourneys.add(j);
			persistJourneys(savedJourneys);
			return true;
		} finally {
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
	
	public ArrayList<Journey> getSavedJourneys(){
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

}
