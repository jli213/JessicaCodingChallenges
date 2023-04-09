package basicjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class FileExercises {

	public static int counting(String string)throws IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		int counter = 0;
		int index = 0;
		String subline = "";
		 BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
		 String line = reader.readLine();
		 line = line.toUpperCase();
		 string = string.toUpperCase();
		 if(line.contains(string)) {
			 while(line !=null) {
				 subline = line.toUpperCase();
				 while(subline.contains(string)) {
					 index = subline.indexOf(string);
					 if(string.length()+2<subline.length()) {
						 subline = subline.substring(index + string.length()+1); 
					 }
					 else {
						 subline = subline.substring(index + string.length());  
					 }
					 counter +=1;
				 	}
				 line = reader.readLine();
				 }
		 }
		 
		 reader.close();
		return counter;
		 
	}

	public void toUpper(String string, String string2) throws IOException,FileNotFoundException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(string2));
		BufferedReader reader = new BufferedReader(new FileReader(string));
		String input = reader.readLine();
		while(input != null) {
			writer.write(input.toUpperCase());
			input = reader.readLine();
			writer.newLine();
		}
		if (input == null) {
			writer.nullWriter();
		}
		reader.close();
		writer.close();
	}
	

}
