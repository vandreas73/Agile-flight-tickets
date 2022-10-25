import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<String[]> data;

    DataBase() {
        data.add(new String[]{"2022-10-21", "Amsterdam", "2022-10-21", "London"});
        data.add(new String[]{"2022-10-2", "Athens", "2022-10-2", "Madrid"});
        data.add(new String[]{"2022-10-21", "Barcelona", "2022-10-21", "Malta"});
        data.add(new String[]{"2022-10-1", "Liverpool", "2022-10-1", "Manchester"});
        data.add(new String[]{"2022-10-31", "Ljubljana", "2022-10-31", "Amsterdam"});
        data.add(new String[]{"2022-3-21", "Berlin", "2022-3-21", "Athens"});
        data.add(new String[]{"2022-3-21", "Budapest", "2022-3-21", "Barcelona"});
        data.add(new String[]{"2022-3-21", "Dublin", "2022-3-21", "Berlin"});
        data.add(new String[]{"2022-10-21", "Düsseldorf", "2022-10-21", "Frankfurt"});
        data.add(new String[]{"2022-8-21", "Frankfurt", "2022-8-21", "Hamburg"});
        data.add(new String[]{"2022-8-14", "Hamburg", "2022-8-14", "Helsinki"});
        data.add(new String[]{"2022-8-21", "Helsinki", "2022-8-21", "Ibiza"});
        data.add(new String[]{"2022-8-6", "Ibiza", "2022-8-6", "Istanbul"});
        data.add(new String[]{"2022-8-21", "Istanbul", "2022-8-21", "Kyiv"});
        data.add(new String[]{"2022-8-21", "Kyiv", "2022-8-21", "Lisbon"});
        data.add(new String[]{"2023-8-5", "London", "2023-8-5", "Barcelona"});
        data.add(new String[]{"2023-3-21", "Lisbon", "2023-3-21", "Berlin"});
        data.add(new String[]{"2023-8-21", "Liverpool", "2023-8-21", "Frankfurt"});
        data.add(new String[]{"2023-8-21", "Ljubljana", "2023-8-21", "Hamburg"});
        data.add(new String[]{"2023-8-21", "Hamburg", "2023-8-21", "Helsinki"});
        data.add(new String[]{"2023-8-4", "Helsinki", "2023-8-4", "Ibiza"});
        data.add(new String[]{"2023-8-7", "Ibiza", "2023-8-7", "Istanbul"});
        data.add(new String[]{"2023-5-7", "Istanbul", "2023-5-7", "Kyiv"});
        data.add(new String[]{"2023-6-21", "Kyiv", "2023-6-21", "LisbonLiverpool"});
        data.add(new String[]{"2023-8-2", "London", "2023-8-2", "Ljubljana"});
        data.add(new String[]{"2023-8-2", "Lisbon", "2023-8-2", "London"});
        data.add(new String[]{"2023-8-21", "Liverpool", "2023-8-21", "Madrid"});
        data.add(new String[]{"2023-10-21", "Berlin", "2023-10-21", "Malta"});
        data.add(new String[]{"2023-10-9", "Budapest", "2023-10-9", "Manchester"});
        data.add(new String[]{"2023-11-9", "Dublin", "2023-11-9", "Budapest"});
        data.add(new String[]{"2023-10-21", "Düsseldorf", "2023-10-21", "Dublin"});
        data.add(new String[]{"2023-4-21", "Frankfurt", "2023-4-21", "Düsseldorf"});
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
