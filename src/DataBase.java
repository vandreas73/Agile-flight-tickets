import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<String[]> data;

    // nem volt inicializálva a változó
    DataBase() {
        this.data = new ArrayList<>();
        data.add(new String[]{"2022-10-21", "Amsterdam", "2022-10-21", "London", "120"});
        data.add(new String[]{"2022-10-02", "Athens", "2022-10-02", "Madrid", "60"});
        data.add(new String[]{"2022-10-21", "Barcelona", "2022-10-21", "Malta", "50"});
        data.add(new String[]{"2022-10-01", "Liverpool", "2022-10-01", "Manchester", "70"});
        data.add(new String[]{"2022-10-31", "Ljubljana", "2022-10-31", "Amsterdam", "90"});
        data.add(new String[]{"2022-03-21", "Berlin", "2022-03-21", "Athens", "60"});
        data.add(new String[]{"2022-03-21", "Budapest", "2022-03-21", "Barcelona", "78"});
        data.add(new String[]{"2022-03-21", "Dublin", "2022-03-21", "Berlin", "15"});
        data.add(new String[]{"2022-10-21", "Düsseldorf", "2022-10-21", "Frankfurt", "30"});
        data.add(new String[]{"2022-08-21", "Frankfurt", "2022-08-21", "Hamburg", "45"});
        data.add(new String[]{"2022-08-14", "Hamburg", "2022-08-14", "Helsinki", "68"});
        data.add(new String[]{"2022-08-21", "Helsinki", "2022-08-21", "Ibiza", "79"});
        data.add(new String[]{"2022-08-06", "Ibiza", "2022-08-06", "Istanbul", "65"});
        data.add(new String[]{"2022-08-21", "Istanbul", "2022-08-21", "Kyiv", "30"});
        data.add(new String[]{"2022-08-21", "Kyiv", "2022-08-21", "Lisbon", "20"});
        data.add(new String[]{"2023-08-05", "London", "2023-08-05", "Barcelona", "40"});
        data.add(new String[]{"2023-03-21", "Lisbon", "2023-03-21", "Berlin", "65"});
        data.add(new String[]{"2023-08-21", "Liverpool", "2023-08-21", "Frankfurt", "78"});
        data.add(new String[]{"2023-08-21", "Ljubljana", "2023-08-21", "Hamburg", "132"});
        data.add(new String[]{"2023-08-21", "Hamburg", "2023-08-21", "Helsinki", "95"});
        data.add(new String[]{"2023-08-04", "Helsinki", "2023-08-04", "Ibiza", "45"});
        data.add(new String[]{"2023-08-07", "Ibiza", "2023-08-07", "Istanbul", "68"});
        data.add(new String[]{"2023-05-07", "Istanbul", "2023-05-07", "Kyiv", "36"});
        data.add(new String[]{"2023-06-21", "Kyiv", "2023-06-21", "LisbonLiverpool", "77"});
        data.add(new String[]{"2023-08-02", "London", "2023-08-02", "Ljubljana", "65"});
        data.add(new String[]{"2023-08-02", "Lisbon", "2023-08-02", "London", "48"});
        data.add(new String[]{"2023-08-21", "Liverpool", "2023-08-21", "Madrid", "54"});
        data.add(new String[]{"2023-10-21", "Berlin", "2023-10-21", "Malta", "79"});
        data.add(new String[]{"2023-10-09", "Budapest", "2023-10-09", "Manchester", "90"});
        data.add(new String[]{"2023-11-09", "Dublin", "2023-11-09", "Budapest", "60"});
        data.add(new String[]{"2023-10-21", "Düsseldorf", "2023-10-21", "Dublin",  "40"});
        data.add(new String[]{"2023-04-21", "Frankfurt", "2023-4-21", "Düsseldorf", "45"});
        data.add(new String[]{"2023-10-21", "Hamburg", "2023-10-21", "Budapest", "64"});
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
