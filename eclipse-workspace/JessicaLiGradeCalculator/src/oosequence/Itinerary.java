package oosequence;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Itinerary {
	String name = "";
	private ArrayList<TripComponent> tripComponents;
	
	public Itinerary(String nameString) {
		name = nameString;
		tripComponents = new ArrayList<TripComponent>();
		// TODO Auto-generated constructor stub
	}

	public void addTripComponent(TripComponent component) {
		// TODO Auto-generated method stub
		int size = tripComponents.size();
		int index = 0;
		if(tripComponents.isEmpty()) {
			tripComponents.add(component);
		}
		else {
			for(int j=0;j<size;j++) {
				if(component.isBefore(tripComponents.get(j))) {
					tripComponents.add(j, component);
					index = j;
					break;
				}
				else if((j==size-1)&&(tripComponents.get(j).isBefore(component))){
						tripComponents.add(component);
						index = j;
				}
			}
			size = tripComponents.size();
			for(int i=0;i<size-2;i++) {
					if(tripComponents.get(i).overlapsWith(tripComponents.get(i+1))){
							tripComponents.remove(index);
				}
			}
		}
        
	}
		
		

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public ArrayList<TripComponent> getTripComponents() {
		// TODO Auto-generated method stub
		return tripComponents;
	}
	
	public String toString() {
		String stringOfTripComponent = name+"\n";
		for(int i =0; i<tripComponents.size();i++) {
//			String numString = Integer.toString(i);
//			stringOfTripComponent.concat(numString);
			stringOfTripComponent = stringOfTripComponent.concat(i+"\t"+tripComponents.get(i).getStart()+"\t"+tripComponents.get(i).getEnd()+"\n");
		}
		return stringOfTripComponent;
	}
	

}
