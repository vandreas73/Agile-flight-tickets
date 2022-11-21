import java.util.Date;

public class Search {
    private Date departureDate;
    private String departureCity;
    private Date arrivalDate;
    private String arrivalCity;


    Search(Date departureDate, String departureCity, Date arrivalDate, String arrivalCity) throws Exception {
        if (departureCity == null || arrivalCity == null) throw new Exception("Invalid city parameter");
        if (departureDate == null && arrivalDate == null) throw new Exception("Both date are null");
        this.departureDate = departureDate;
        this.departureCity = departureCity;
        this.arrivalDate = arrivalDate;
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureDate() { return departureDate; }
    public String getDepartureCity() { return departureCity; }
    public Date getArrivalDate() { return arrivalDate; }
    public String getArrivalCity() { return arrivalCity; }

}
