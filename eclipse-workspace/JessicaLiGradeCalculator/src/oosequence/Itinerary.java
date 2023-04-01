package oosequence;

import static org.junit.Assert.assertEquals;

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
		Flight flightToAddCopy = new Flight(flightToAdd);
		int size = flights.size();
		int index = 0;
		if(flights.isEmpty()) {
			flights.add(flightToAddCopy);
		}
		else {
			for(int j=0;j<size;j++) {
				if(flights.get(j).getArrival().after(flightToAddCopy.getArrival())) {
					flights.add(j, flightToAddCopy);
					index = j;
					break;
				}
				else if((j==size-1)&&((flightToAddCopy.getArrival().after(flights.get(j).getArrival())))){
						flights.add(flightToAddCopy);
						index = j;
				}
			}
			size = flights.size();
			for(int i=0;i<size-2;i++) {
					if(flights.get(i).getArrival().after(flights.get(i+1).getDeparture())){
							flights.remove(index);
				}
			}
		}
        
	}

	public long getTotalLayover() {
		// TODO Auto-generated method stub
		long arrival,departure,layover=0;
		for(int i=0;i<flights.size()-1;i++) {
			arrival = flights.get(i).getArrival().getTime();
			departure =  flights.get(i+1).getDeparture().getTime();
			layover += departure - arrival;
		}
		layover = layover/60000;
		return layover;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	

	public ArrayList<Flight> getFlightList() {
		// TODO Auto-generated method stub
		return flights;
	}
	

}
