package basicjava;

import java.util.Arrays;
import java.text.Collator;


public class CCArrays {

	public static void replace(char[] chars, char c, char d) {
		// TODO Auto-generated method stub	
		
		int length = chars.length;
		for(int i=0;i<length;i++) {
			System.out.println("before "+chars[i]);
			if(chars[i] == c || chars[i] == (char)c+32|| chars[i] ==(char) c-32){
				chars[i] = d;
				System.out.println("after "+chars[i]);
			}
		}
	}

	public static void sortAlphabetic(String[] strs) {
		// TODO Auto-generated method stub
		Arrays.sort(strs, Collator.getInstance());
		
	}

}
