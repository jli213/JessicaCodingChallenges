package basicjava;

public class CCStringsIfAndWhile {

	
	/**
	 * if character entered was a digit then function returns true else it returns false
	 * @param c character that was being tested 
	 * @return true or false 
	 */
	public static boolean isDigit(char c) {
		// TODO Auto-generated method stub
		return Character.isDigit(c);
	}
	
	
	//https://stackoverflow.com/questions/10223176/how-to-compare-character-ignoring-case-in-primitive-types
	//https://www.techiedelight.com/iterate-over-characters-string-java/#:~:text=Iterate%20over%20characters%20of%20a%20String%20in%20Java,8%208.%20Using%20Code%20Points%20...%20More%20items
	
	/**
	 * compare two strings and counts the number of characters in the string that were the same 
	 * @param string first string 
	 * @param string2 second string
	 * @return number of characters that were the same
	 */
	public static int count(String string, String string2) {
		// TODO Auto-generated method stub
		int sum =0;
		if(string.equals("")|| string2.equals(""))
		{
			return 0;
		}
		
		
		for (char ch: string.toLowerCase().toCharArray()){
			for (char ch2: string2.toLowerCase().toCharArray()){
				if (ch2 == ch) {
					sum +=1;
				}
			}
		}
		return sum;
	}
	
	/**
	 * takes the number provided and returns the smallest digit in the number 
	 * @param i the number from which we want the smallest digit
	 * @return the smallest digit in the integer
	 */
	public static int smallestDigit(int i) {
		// TODO Auto-generated method stub
		if(i==0) {
			return 0;
		}
		
		String str = Integer.toString(i);
		int min = str.charAt(0)-'0';
		
		for(int m = 0;m<str.length()-1;m++) {
				if(str.charAt(m)>str.charAt(m+1)) {
				min = str.charAt(m+1)-'0';
				System.out.println("min"+min);
			}
		}
		
		return min;
	}

}
