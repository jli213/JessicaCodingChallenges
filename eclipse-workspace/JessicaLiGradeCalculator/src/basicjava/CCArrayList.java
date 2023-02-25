package basicjava;

import java.util.ArrayList;

public class CCArrayList {

	public static int indexOfIgnoreCase(ArrayList<String> strs, String string) {
		// TODO Auto-generated method stub
		for (int i =0;i<strs.size();i++) {
			if(strs.get(i).equalsIgnoreCase(string)){
				return i;
			}
		}
		return -1;
		
	}

	public static void insert(ArrayList<Double> nums, double d, int i) {
		// TODO Auto-generated method stub
		
	}
	

}
