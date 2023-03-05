package oosequence;

import java.util.Date;

public class Flight {

	public Date departure;
	public Date arrival;

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

}
