import java.util.ArrayList;
import java.util.Comparator;

public class Sort {

    MockupDB db;

    public  Sort(String connection) {
        // initialize the connection
        this.db = new MockupDB(connection);
    }

    public boolean isDatabaseEmpty() {
        return db == null;
    }

    public void sortDatabaseByPrice() {
        db.data.sort(Comparator.comparingInt(f -> f.price));
    }

    public void sortDatabaseByDeparture() {
        db.data.sort(Comparator.comparing(f -> f.departureCity));
    }

    public void sortDatabaseByArrival() {
        db.data.sort(Comparator.comparing(f -> f.arrivalCity));
    }
}
