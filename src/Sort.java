import java.util.ArrayList;

public class Sort {

    MockupDB db;

    public  Sort(String connection) {
        // initialize the connection
        this.db = new MockupDB(connection);
    }

    public boolean isDatabaseEmpty() {
        return db == null;
    }

    public ArrayList<Flight> sortDatabaseByDeparture(String destination) {
        return null;
    }
}
