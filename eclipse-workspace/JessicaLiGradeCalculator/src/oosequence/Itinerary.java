package oosequence;

import java.util.ArrayList;

public class Itinerary {
	
	private ArrayList<Flight> flights;
	private String name = null;

	public Itinerary(String nameString) {
		name = nameString;
		flights = new ArrayList<Flight>();
		// TODO Auto-generated constructor stub
	}

	public void addFlight(Flight flightToAdd) {
		// TODO Auto-generated method stub
		int size = flights.size();
		if(flights.isEmpty()) {
			flights.add(flightToAdd);
		}
		else {
			for(int j=0;j<size;j++) {
				if(j==size-1){
					if (flightToAdd.getArrival().after(flights.get(j).getArrival())) {
						if(flightToAdd.getDeparture().after(flights.get(j).getArrival())){
							flights.add(j, flightToAdd);
						}
					}
					if (flightToAdd.getArrival().after(flights.get(j).getArrival())) {
						if(flightToAdd.getDeparture().after(flights.get(j).getArrival())){
							flights.add(j, flightToAdd);
						}
					}
				}
				else if(flights.get(j).getArrival().after(flightToAdd.getArrival())) {
					if(flights.get(j-1).getDeparture().after(flightToAdd.getArrival())){
						if(flightToAdd.getDeparture().after(flights.get(j).getArrival())) {
							flights.add(j, flightToAdd);
						}
					} 
				}
			}
		}
		
	}

	public long getTotalLayover() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public ArrayList<Flight> getFlights() {
		// TODO Auto-generated method stub
		return flights;
	}
	

}
