import java.util.ArrayList;
import java.util.Date;

public class MockupDB {
    String dataBaseConnection;

    ArrayList<Flight> data;

    MockupDB(String dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public final void setUpInitialData() {
        var list = new ArrayList<Flight>();
        list.add(new Flight(new Date(2022-11-10), "Budapest", new Date(2022-11-10), "Hamburg", 50));
        list.add(new Flight(new Date(2022-11-10), "Nokia", new Date(2022-11-10), "Budapest", 80));
        list.add(new Flight(new Date(2022-11-10), "Bratislava", new Date(2022-11-10), "Milano", 35));
        list.add(new Flight(new Date(2022-11-10), "Budapest", new Date(2022-11-10), "London", 42));
        list.add(new Flight(new Date(2022-11-10), "Vienna", new Date(2022-11-10), "Bern", 25));
        list.add(new Flight(new Date(2022-11-10), "Bern", new Date(2022-11-10), "Vienna", 39));
        list.add(new Flight(new Date(2022-11-10), "Warsaw", new Date(2022-11-10), "Brussels", 46));
        list.add(new Flight(new Date(2022-11-10), "Madrid", new Date(2022-11-10), "Istanbul", 79));
        list.add(new Flight(new Date(2022-11-10), "Dublin", new Date(2022-11-10), "Oslo", 82));
        list.add(new Flight(new Date(2022-11-10), "Edinburgh", new Date(2022-11-10), "Cardiff", 18));
        list.add(new Flight(new Date(2022-11-10), "Porto", new Date(2022-11-10), "Barcelona", 34));

        data = new ArrayList<>();
        data.addAll(list);
    }

    public Journey[] selectJourneysFromTo(String departureCity, String arriveCity) {
        Journey journey1 = new Journey();
        Journey journey2 = new Journey();
        Journey journey3 = new Journey();

        Flight flight1 = new Flight(new Date(2022-11-21), "Berlin", new Date(2022-11-21), "München");
        Flight flight2 = new Flight(new Date(2022-11-21), "München", new Date(2022-11-22), "Roma");
        Flight flight3 = new Flight(new Date(2022-11-23), "Berlin", new Date(2022-11-23), "Roma");
        Flight flight4 = new Flight(new Date(2022-11-21), "Berlin", new Date(2022-11-21), "München");
        Flight flight5 = new Flight(new Date(2022-11-21), "München", new Date(2022-11-21), "Budapet");
        Flight flight6 = new Flight(new Date(2022-11-21), "Budapest", new Date(2022-11-21), "Roma");

        journey1.addFlight(flight1);
        journey1.addFlight(flight2);

        journey2.addFlight(flight3);

        journey3.addFlight(flight4);
        journey3.addFlight(flight5);
        journey3.addFlight(flight6);

        return new Journey[]{journey1, journey2, journey3};
    }

    public Journey[] selectJourneysFromToAt(String departureCity, Date departureDate, String arriveCity, Date arriveDate) {
        Journey journey1 = new Journey();
        Journey journey3 = new Journey();

        Flight flight1 = new Flight(new Date(2022-11-21), "Berlin", new Date(2022-11-21), "München");
        Flight flight2 = new Flight(new Date(2022-11-21), "München", new Date(2022-11-22), "Roma");
        Flight flight4 = new Flight(new Date(2022-11-21), "Berlin", new Date(2022-11-21), "München");
        Flight flight5 = new Flight(new Date(2022-11-21), "München", new Date(2022-11-21), "Budapet");
        Flight flight6 = new Flight(new Date(2022-11-21), "Budapest", new Date(2022-11-21), "Roma");

        journey1.addFlight(flight1);
        journey1.addFlight(flight2);

        journey3.addFlight(flight4);
        journey3.addFlight(flight5);
        journey3.addFlight(flight6);

        return new Journey[]{journey1, journey3};
    }
}
