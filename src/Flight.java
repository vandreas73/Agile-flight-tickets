import java.util.Date;

public class Flight {
	private Date departureDate;
	private String departureCity;
	private Date arrivalDate;
	private String arrivalCity;
	
	public Flight(Date departureDate, String departureCity, Date arrivalDate, String arrivalCity) {
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
	}
}
