package basicjava;

import java.util.ArrayList;

public class RecursionExercises {

	public int countDigits(int num) {
		// TODO Auto-generated method stub
		if(num==0) return 1;
		
		int digit = countDigits(num/10);
		
		if(num>=10) digit += 1;
		
		return digit;
	}

	public int addDigits(int num) {
		// TODO Auto-generated method stub
		if(num<10) return num;
		int sum = addDigits(num/10);
		sum += num%10;

		
		return sum;
	}

	public int sum(int sumFrom, int sumTo) {
		// TODO Auto-generated method stub
		if(sumFrom<0 || sumTo<0 || sumFrom>sumTo) return 0;
		if(sumFrom == sumTo) return sumFrom;

		int total = sum(sumFrom+1,sumTo);
		total += sumFrom;
		
		
		return total;
	}

	public int sumEvenNumbers(int num) {
		// TODO Auto-generated method stub
		if(num <=0) return 0;
		if(num==1) return 0;
		int sum = sumEvenNumbers(num-2);
		if(num%2==0) {
			sum+=num;
		}
		return sum;
	}


	public int sumOfMultiple(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int startIndex=0;
		int sum = sumEvenNumbersHelper(list,startIndex);
		return sum;
	}
	public int sumEvenNumbersHelper(ArrayList<Integer> list,int startIndex) {
		if(list == null) return 0;
		if(list.size()-1 <startIndex) return 0;
		int sum = sumEvenNumbersHelper(list, startIndex+1);
		int index = list.get(startIndex);
		if(index%5==0) {
			System.out.println(startIndex);
			sum+=list.get(startIndex);
		}
		return sum;
		
	}
	
	public int countVowels(String str) {
		// TODO Auto-generated method stub
		if(str == null) return 0;
		if(str.length()-1<0) return 0;
		int count = countVowels(str.substring(1));
		String aString = str.substring(0,1).toLowerCase();
		if(aString.equals("a")||aString.equals("e")||aString.equals("i")
				||aString.equals("o")||aString.equals("u")) {
			count +=1;
		}

		
		return count;
	}

	
	public String removeVowels(String str) {
		// TODO Auto-generated method stub
		if(str == null) return null;
		if(str.length()-1<0) return "";
		String newString = removeVowels(str.substring(1));
		String aString = str.substring(0,1).toLowerCase();
//		System.out.println(aString);
		if(aString.equals("a")||aString.equals("e")||aString.equals("i")
				||aString.equals("o")||aString.equals("u")) {
		}
		else {
			newString = aString.concat(newString);
		}
		return newString;
	}

}
