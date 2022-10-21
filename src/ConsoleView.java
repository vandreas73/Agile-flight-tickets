import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

	public void run() {
		Map<String,Command> commands = new HashMap<>();
    	
    	commands.put("add",ConsoleView::search);

    	// on exit we call System.exit
    	commands.put("exit", (s)->{System.exit(0);});
    	
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            String[] cmd = line.split(" ");
            
            // ha az exit break-et hiv, azt nem tudjuk lambdaba tenni :(
            if ("exit".equals(cmd[0])) {
                break;
            }
            
            Command c = commands.get(cmd[0]);
            if (c!=null) {
            	c.execute(cmd);
            } else {
            	System.out.println("No such command: "+cmd);
            }
        }
	}
	
	private static void search(String[] args) {
	}

	Map<String,Command> commands = new HashMap<>();
	    	
	    	commands.put("add",ConsoleView::search);
	
	    	// on exit we call System.exit
	    	commands.put("exit", (s)->{System.exit(0);});
	    	
	        Scanner sc = new Scanner(System.in);
	
	        while (true) {
	            String line = sc.nextLine();
	            String[] cmd = line.split(" ");
	            
	            // ha az exit break-et hiv, azt nem tudjuk lambdaba tenni :(
	            if ("exit".equals(cmd[0])) {
	                break;
	            }
	            
	            Command c = commands.get(cmd[0]);
	            if (c!=null) {
	            	c.execute(cmd);
	            } else {
	            	System.out.println("No such command: "+cmd);
	            }
	        }
		}
		
		private static void search(String[] args) {
		}
}
