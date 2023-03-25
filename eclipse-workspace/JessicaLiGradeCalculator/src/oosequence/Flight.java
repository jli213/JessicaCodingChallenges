package oosequence;

public class Flight extends TripComponent {
	private String departureAirport = null;
	private String arrivalAirport = null;
	
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String airport) {
		if(airport == null) {
			departureAirport = "";
		}
		else if(airport.length() == 3) {
			this.departureAirport = airport;
		}
		else {
			departureAirport = "";
		}
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String airport) {
		if(airport == null) {
			arrivalAirport = "";
		}
		else if(airport.length() == 3) {
			this.arrivalAirport = airport;
		}
		else {
			arrivalAirport = "";
		}
	} 
	
	public String getDuration() {
		Long length = lengthInSeconds();
		length = length/60;
		return Long.toString(length)+" minutes";
	}
	
	

}
