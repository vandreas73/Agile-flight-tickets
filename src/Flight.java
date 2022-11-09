import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight implements Serializable{
	private static final long serialVersionUID = 1L;
	Date departureDate;
	String departureCity;
	Date arrivalDate;
	String arrivalCity;
	
	public Flight (Date departureDate, String departureCity, Date arrivalDate, String arrivalCity) {
		this.departureDate = departureDate;
		this.departureCity = departureCity;
		this.arrivalDate = arrivalDate;
		this.arrivalCity = arrivalCity;
	}
	
	public Flight (String departureDate, String departureCity, String arrivalDate, String arrivalCity) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		this.departureDate = new Date();
		try {
			this.departureDate = ft.parse("2022-11-02");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.arrivalDate = new Date();
		try {
			this.arrivalDate = ft.parse("2022-11-03");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}
	
	@Override
	public String toString() {
		return "Departure: " + departureDate + " " + departureCity + "\n"
				+ "\tArrival: " + arrivalDate + " " + arrivalCity;
	}
	
	

}
