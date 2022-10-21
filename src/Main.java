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

    	// on exit we call System.exit
    	commands.put("exit", (s)->{sc.close(); System.exit(0);});
    	

        while (true) {
            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            
            
            Command c = commands.get(cmd[0]);
            if (c!=null) {
            	c.execute(cmd);
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
	
	
	private static void search(String[] args) {
		String[] line = inputLine("When, city of departure, city of arrival.", "1970-08-08 Budapest Paris");

		try{
			Date departureDate = Date.valueOf(line[1]);
			String departureCity = line[2];
			String arrivalCity = line[3];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static ArrayList<Journey> listJournies(Date departureDate, String departureCity, String arrivalCity){
		//TODO: járatok keresése
		return new ArrayList<Journey>();
	}
	
	private static void saveJourney(String[] args) {
		String[] line = inputLine("When, city of departure, city of arrival.", "1970-08-08 Budapest Paris");
		
		ArrayList<Journey> journies;
		try{
			Date departureDate = Date.valueOf(line[0]);
			String departureCity = line[1];
			String arrivalCity = line[2];
			journies = listJournies(departureDate, departureCity, arrivalCity);
			String[] line2 = inputLine("Which journey do you want to save?", "1");
			savedJourneys.add(journies.get(Integer.parseInt(line2[0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
