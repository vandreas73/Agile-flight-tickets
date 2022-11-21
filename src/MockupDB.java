import java.util.Date;

public class MockupDB {
    String dataBaseConnection;
    MockupDB(String dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
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
