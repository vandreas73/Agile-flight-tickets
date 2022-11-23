import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
	Control control = new Control();

	public void run() {
		Map<String,Command> commands = new HashMap<>();
		Scanner sc = new Scanner(System.in);
    	
		commands.put("search", s -> search(s));
		commands.put("saveJourney", s -> saveJourney(s));
    	commands.put("getSavedJourneys", s -> getSavedJourneys(s));
    	commands.put("deleteSavedJourney", s -> deleteSavedJourney(s));
    	commands.put("clearSavedJourneys", s -> clearSavedJourneys(s));
		commands.put("sortFlightsByDepartureCity", s -> sortFlightsByDepartureCity(s));
		commands.put("sortFlightsByArrivalCity", s -> sortFlightsByArrivalCity(s));
		commands.put("sortFlightsByPrice", this::sortFlightsByPrice);

    	commands.put("help", s -> help(s));
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
            		System.out.println("Unknown format");
            	}
            } else {
            	System.out.println("No such command: "+cmd);
            }
        }
	}
	
	private void help(String[] args) {
		System.out.println("The expected input:\n\n"
				+ "search when departureCity arrivalCity\n"
				+ "\texample: search 2023-08-21 Liverpool Madrid\n\n"
				+ "saveJourney when departureCity arrivalCity searchId\n"
				+ "\texample: saveJourney 2023-08-21 Liverpool Madrid 0\n\n"
				+ "getSavedJourneys\n"
				+ "\texample: getSavedJourneys\n\n"
				+ "deleteSavedJourney index\n"
				+ "\texample: deleteSavedJourney 0\n\n"
				+ "clearSavedJourneys\n"
				+ "\t example: clearSavedJourneys\n\n"
				+"sortFlightsByDepartureCity\n"
				+"\t example: sortFlightsByDepartureCity Budapest\n\n"
				+ "sortFlightsByArrivalCity\n"
				+ "\t example: sortFlightsByArrivalCity Budapest\n\n"
				+ "sortFlightsByPrice\n"
				+ "\t example: sortFlightsByPrice Budapest");
	}
	
	void search(String[] args) throws Exception {
		Date departureDate = Date.valueOf(args[1]);
		String departureCity = args[2];
		String arrivalCity = args[3];
		
		ArrayList<Journey> journeys = control.listJourneys(departureDate, departureCity, arrivalCity);
		if (journeys.isEmpty()){
			System.out.println("No journey in this date");
		}
		printJourneys(journeys);
	}
	
	void saveJourney(String[] args) throws Exception {
		Date departureDate = Date.valueOf(args[1]);
		String departureCity = args[2];
		String arrivalCity = args[3];
		int id = Integer.parseInt(args[4]);
		
		if (control.saveJourney(departureDate, departureCity, arrivalCity, id))
			System.out.println("Saved succesfully.");
		else
			System.out.println("Couldn't save.");
	}
	
	void getSavedJourneys(String[] args) throws Exception {
		var journeys = control.getSavedJourneys();
		printJourneys(journeys);
		if (journeys.isEmpty()) System.out.println("No journeys saved.");
		
	}
	
	void deleteSavedJourney(String[] args) throws Exception {
		if (control.deleteSavedJourney(Integer.parseInt(args[1])))
			System.out.println("Deleted successfully.");
		else {
			System.out.println("Couldn't delete");
		}
	}
	
	private void printJourneys(List<Journey> journeyList) {
		if (journeyList.isEmpty()) {
			return;
		}
		for (int i = 0; i < journeyList.size(); i++) {
        	System.out.println(i + ". journey:\n" + journeyList.get(i));
		}
	}
	
	void clearSavedJourneys(String[] args) {
		control.clearSavedJourneys();
	}

	void sortFlightsByDepartureCity(String[] args) {
		var departureCity = args[1];
		var out = control.sortFlightsByDepartureCity(departureCity);
		System.out.println("From " + departureCity + " to:");
		out.forEach(c -> System.out.println("\t" + c[3] + " at: " + c[0]));
	}

	void sortFlightsByArrivalCity(String[] args) {
		var arrivalCity = args[1];
		var out = control.sortFlightsByArrivalCity(arrivalCity);
		System.out.println("To " + arrivalCity + " from:");
		out.forEach(c -> System.out.println("\t" + c[1] + " at: " + c[2]));
	}

	void sortFlightsByPrice(String[] args) {
		var out = control.sortFlightsByPrice(args);

		System.out.println("From " + args[1] + " to:");
		out.forEach(c -> System.out.println("\t" + c[3] + " for: " + c[4]));
	}
}
