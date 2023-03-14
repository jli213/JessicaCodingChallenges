package oosequence;

import java.util.Date;

public class Flight {

	private Date departure = null;
	private Date arrival = null;

	public Flight(Date departureTime, Date arrivalTime) {
		if(departureTime == null || arrivalTime == null) {
			departure = departureTime;
			arrival = arrivalTime;
		}
		else {
			if(departureTime.before(arrivalTime)) {
				departure = departureTime;
				arrival = arrivalTime;
			}
			else {
				departure = null;
				arrival = null;
			}
		}
	}

	public Flight(Flight toCopy) {
		departure = toCopy.departure;
		arrival = toCopy.arrival;
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
		return departure;
	}

	public Date getArrival() {
		// TODO Auto-generated method stub
		return arrival;
	}
	
	public void setDeparture(Date departureTime) {
		// TODO Auto-generated method stub
		if(departureTime == null ||arrival == null) {
			departure = departureTime;
		}
		else {
			if(departureTime.before(arrival)) {
				departure = departureTime;
			}
		}
	}

	public void setArrival(Date arrivalTime) {
		// TODO Auto-generated method stub
		if(arrivalTime == null || departure == null) {
			arrival = arrivalTime;
		}
		else {
			if(departure.before(arrivalTime)) {
				arrival = arrivalTime;
			}
		}
	}

}
