import java.sql.Date;
import java.util.ArrayList;

public class JourneyDataSet {
    private ArrayList<JourneyData> journeyDatas;


    public int getJourneyNum() {
        return journeyDatas.size();
    }

    public JourneyData getJourney(int i) {
        return journeyDatas.get(i);
    }

    public void add(JourneyData journeyD) {
        journeyDatas.add(journeyD);
    }
}
