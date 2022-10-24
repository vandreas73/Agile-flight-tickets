import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	@Override
	public String toString() {
		return "Departure: " + departureDate + " " + departureCity + "\n"
				+ "\tArrival: " + arrivalDate + " " + arrivalCity;
	}
}
