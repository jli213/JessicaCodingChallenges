package oosequence;

import java.util.Date;

public class Flight extends TripComponent {
	private String departureAirport = "";
	private String arrivalAirport = "";
	
	public Flight(Date departureTime, Date arrivalTime, String departureAirportName, String arrivalAirportName) {
		super(departureTime,arrivalTime);
		setDepartureAirport(departureAirportName);
		setArrivalAirport(arrivalAirportName);
	}
	public Flight(Flight toCopy) {
		// TODO Auto-generated constructor stub
		super(toCopy);
		departureAirport = toCopy.departureAirport;
		arrivalAirport = toCopy.arrivalAirport;
	}
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
	
	public String getStart() {
		return departureAirport+" "+super.getStart();
	}
	
	public String getEnd(){
		return arrivalAirport+" "+super.getEnd();
	}
	

}
