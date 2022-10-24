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
    	
		commands.put("search", (s -> search(s)));
		commands.put("saveJourney", s -> saveJourney(s));
    	commands.put("getSavedJourneys", s -> getSavedJourneys(s));

    	commands.put("help", s -> help(s));
    	// on exit we call System.exit
    	commands.put("exit", (s)->{sc.close(); System.exit(0);});
    	

        while (true) {
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
		System.out.println("The expected input:\n"
				+ "search when departureCity arrivalCity\n"
				+ "example: search 1970-08-08 Budapest Paris\n\n"
				+ "saveJourney when departureCity arrivalCity searchId\n"
				+ "example: saveJourney 1970-08-08 Budapest Paris 0\n\n"
				+ "getSavedJourneys\n"
				+ "example: getSavedJourneys");
	}
	
	void search(String[] args) throws Exception {
		Date departureDate = Date.valueOf(args[1]);
		String departureCity = args[2];
		String arrivalCity = args[3];
		
		ArrayList<Journey> journeys = control.listJourneys(departureDate, departureCity, arrivalCity);
		printJourneys(journeys);
	}
	
	void saveJourney(String[] args) throws Exception {
		ArrayList<Journey> journeys;
		Date departureDate = Date.valueOf(args[1]);
		String departureCity = args[2];
		String arrivalCity = args[3];
		int id = Integer.parseInt(args[4]);
		
		control.saveJourney(departureDate, departureCity, arrivalCity, id);
	}
	
	void getSavedJourneys(String[] args) throws Exception {
		printJourneys(control.getSavedJourneys());
	}
	
//	void deleteSavedJourney(String[] args) throws Exception {
//		
//	}
	
	private void printJourneys(List<Journey> journeyList) {
		for (int i = 0; i < journeyList.size(); i++) {
        	System.out.println(i + ". journey:\n" + journeyList.get(i));
		}
	}
}
