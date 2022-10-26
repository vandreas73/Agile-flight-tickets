import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DataBase {
    ArrayList<String[]> data;

    // nem volt inicializálva a változó
    DataBase() {
        this.data = new ArrayList<>();
        data.add(new String[]{"2022-10-21", "Amsterdam", "2022-10-21", "London"});
        data.add(new String[]{"2022-10-02", "Athens", "2022-10-02", "Madrid"});
        data.add(new String[]{"2022-10-21", "Barcelona", "2022-10-21", "Malta"});
        data.add(new String[]{"2022-10-01", "Liverpool", "2022-10-01", "Manchester"});
        data.add(new String[]{"2022-10-31", "Ljubljana", "2022-10-31", "Amsterdam"});
        data.add(new String[]{"2022-03-21", "Berlin", "2022-03-21", "Athens"});
        data.add(new String[]{"2022-03-21", "Budapest", "2022-03-21", "Barcelona"});
        data.add(new String[]{"2022-03-21", "Dublin", "2022-03-21", "Berlin"});
        data.add(new String[]{"2022-10-21", "Düsseldorf", "2022-10-21", "Frankfurt"});
        data.add(new String[]{"2022-08-21", "Frankfurt", "2022-08-21", "Hamburg"});
        data.add(new String[]{"2022-08-14", "Hamburg", "2022-08-14", "Helsinki"});
        data.add(new String[]{"2022-08-21", "Helsinki", "2022-08-21", "Ibiza"});
        data.add(new String[]{"2022-08-06", "Ibiza", "2022-08-06", "Istanbul"});
        data.add(new String[]{"2022-08-21", "Istanbul", "2022-08-21", "Kyiv"});
        data.add(new String[]{"2022-08-21", "Kyiv", "2022-08-21", "Lisbon"});
        data.add(new String[]{"2023-08-05", "London", "2023-08-05", "Barcelona"});
        data.add(new String[]{"2023-03-21", "Lisbon", "2023-03-21", "Berlin"});
        data.add(new String[]{"2023-08-21", "Liverpool", "2023-08-21", "Frankfurt"});
        data.add(new String[]{"2023-08-21", "Ljubljana", "2023-08-21", "Hamburg"});
        data.add(new String[]{"2023-08-21", "Hamburg", "2023-08-21", "Helsinki"});
        data.add(new String[]{"2023-08-04", "Helsinki", "2023-08-04", "Ibiza"});
        data.add(new String[]{"2023-08-07", "Ibiza", "2023-08-07", "Istanbul"});
        data.add(new String[]{"2023-05-07", "Istanbul", "2023-05-07", "Kyiv"});
        data.add(new String[]{"2023-06-21", "Kyiv", "2023-06-21", "LisbonLiverpool"});
        data.add(new String[]{"2023-08-02", "London", "2023-08-02", "Ljubljana"});
        data.add(new String[]{"2023-08-02", "Lisbon", "2023-08-02", "London"});
        data.add(new String[]{"2023-08-21", "Liverpool", "2023-08-21", "Madrid"});
        data.add(new String[]{"2023-10-21", "Berlin", "2023-10-21", "Malta"});
        data.add(new String[]{"2023-10-09", "Budapest", "2023-10-09", "Manchester"});
        data.add(new String[]{"2023-11-09", "Dublin", "2023-11-09", "Budapest"});
        data.add(new String[]{"2023-10-21", "Düsseldorf", "2023-10-21", "Dublin"});
        data.add(new String[]{"2023-04-21", "Frankfurt", "2023-4-21", "Düsseldorf"});
        data.add(new String[]{"2023-10-21", "Hamburg", "2023-10-21", "Budapest"});
    }

    public JourneyDataSet SelectFunctionWithParams(Date departureDate, String departureCity, String arrivalCity) throws ParseException {
        JourneyDataSet journeyDataSet =  new JourneyDataSet();

        for (String[] s: data) {
            if (s[0].equals(departureDate.toString()) && s[1].equals(departureCity) && s[3].equals(arrivalCity)) {
                journeyDataSet.add(new JourneyData(s[0], s[1], s[2], s[3]));
            }
        }

        return journeyDataSet;
    }
}
