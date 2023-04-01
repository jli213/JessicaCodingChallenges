package oosequence;

import java.util.Date;

public class Flight {

	private Date departure = null;
	private Date arrival = null;

	public Flight(Date departureTime, Date arrivalTime) {
		if(departureTime == null && arrivalTime == null) {
			departure = null;
			arrival = null;
		}
		else if(departureTime == null) {
			departure = null;
			arrival = new Date(arrivalTime.getTime());
		}
		else if(arrivalTime == null) {
			departure = new Date(departureTime.getTime());
			arrival = null;
		}
		else {
			if(departureTime.before(arrivalTime)) {
				departure = new Date(departureTime.getTime());
				arrival = new Date(arrivalTime.getTime());
			}
			else {
				departure = null;
				arrival = null;
			}
		}
	}

	public Flight(Flight toCopy) {
		if(toCopy.departure == null && toCopy.arrival == null) {
			departure = null;
			arrival = null;
		}
		else if(toCopy.departure == null) {
			departure = null;
			arrival = new Date (toCopy.arrival.getTime());
		}
		else if(toCopy.arrival == null) {
			departure = new Date (toCopy.departure.getTime());
			arrival = null;
		}
		else {
			departure = new Date (toCopy.departure.getTime());
			arrival = new Date (toCopy.arrival.getTime());
		}
	}

	public long length() {
		long time;
		if(arrival == null || departure == null) {
			return 0;
		}
		else {
			time = arrival.getTime() - departure.getTime();
		}
		return time/60000;
	}

	public Date getDeparture() {
		// TODO Auto-generated method stub
		if(departure == null) {
			return null;
		}
		else {
			return new Date(departure.getTime());
		}
	}

	public Date getArrival() {
		// TODO Auto-generated method stub
		if(arrival == null) {
			return null;
		}
		else {
			return new Date(arrival.getTime());
		}
	}
	
	public void setDeparture(Date departureTime) {
		// TODO Auto-generated method stub
		if(departureTime == null ||arrival == null) {
			departure = new Date(departureTime.getTime());
		}
		else {
			if(departureTime.before(arrival)) {
				departure = new Date(departureTime.getTime());
			}
		}
	}

	public void setArrival(Date arrivalTime) {
		// TODO Auto-generated method stub
		if(arrivalTime == null || departure == null) {
			arrival = new Date(arrivalTime.getTime());
		}
		else {
			if(departure.before(arrivalTime)) {
				arrival = new Date(arrivalTime.getTime());
			}
		}
	}

}