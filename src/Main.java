import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static List<Journey> savedJourneys = new ArrayList<>();

	public static void main(String[] args) {
		Map<String,Command> commands = new HashMap<>();
		Scanner sc = new Scanner(System.in);
    	
		commands.put("search", Main::search);
		commands.put("saveJourney", Main::saveJourney);
    	commands.put("getSavedJourneys", Main::getSavedJourneys);

    	// on exit we call System.exit
    	commands.put("exit", (s)->{sc.close(); System.exit(0);});
    	

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            
            
            Command c = commands.get(cmd[0]);
            if (c!=null) {
            	try{
            		c.execute(cmd);
            	} catch (Exception e) {
            		System.out.println("Hibás formátum");
            	}
            } else {
            	System.out.println("No such command: "+cmd);
            }
        }
	}
	
	private static String[] inputLine(String command, String exampleFormat) {
		System.out.println(command +
				"\nExample: " + exampleFormat);
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		sc.close();
		return line;
	}
	
	
	private static void search(String[] args) throws Exception {
		//String[] line = inputLine("When, city of departure, city of arrival.", "1970-08-08 Budapest Paris");

			Date departureDate = Date.valueOf(args[1]);
			String departureCity = args[2];
			String arrivalCity = args[3];
		
	}
	
	private static ArrayList<Journey> listJourneys(Date departureDate, String departureCity, String arrivalCity){
		//TODO: járatok keresése
		ArrayList<Journey> journeys = new ArrayList<>();
		journeys.add(new Journey());
		journeys.get(0).addFlight(new Flight(Date.valueOf("2022-10-21"), "Budapest", Date.valueOf("2022-10-21"), "Berlin"));
		return journeys;
	}
	
	private static void saveJourney(String[] args) throws Exception {
		//String[] line = inputLine("When, city of departure, city of arrival.", "1970-08-08 Budapest Paris");
		
		ArrayList<Journey> journeys;
		Date departureDate = Date.valueOf(args[1]);
		String departureCity = args[2];
		String arrivalCity = args[3];
		int id = Integer.parseInt(args[4]);
		journeys = listJourneys(departureDate, departureCity, arrivalCity);
		//String[] line2 = inputLine("Which journey do you want to save?", "1");
		savedJourneys.add(journeys.get(id));
		
	}
	
	private static void getSavedJourneys(String[] args) throws Exception {
		for (Journey journey : savedJourneys) {
			System.out.println(journey);
		}
	}
	
	
	

}
