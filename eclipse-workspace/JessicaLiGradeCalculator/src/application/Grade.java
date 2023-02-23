package application;

public class Grade {
	//attributes/data
	double value =0;
	double weight;
	int maxValue;
	
	double getWeightedPercentageValue(){
		return value *100 *weight /maxValue;
	}
	
	//actions
	String setValue(String valueAsString) {
    	boolean validGrade = true;
    	int counter =0; //set counter of number of character decimal to 0
    	String errorMessage = "";
    	
    	for (char c : valueAsString.toCharArray()) {
    		if(!Character.isDigit(c)) {
    			//if any number is not a digit or is not a real number, set flag to false, it is not a number
    			validGrade = false;
    			//check if value entered has decimals and see if it is a real number
    			if(c =='.') {
        			if(counter==0)
        			{
        				counter +=1;
        				validGrade = true;
        			}
    			}
    			if(!validGrade)
				{
					errorMessage = String.format("Don't include the character %c." +  
        					" Project Grade should be percentage." , c);
				}
    		}
    	}
    	
    	//Default project grade to 0. If valid number entered, convert input to 
    	//floating point number.
    	
    	
    	if(validGrade)
    	{
    		value = Double.parseDouble(valueAsString);	
    		System.out.println(value);
    	}
    	
    	//Check if user entered a percentage grade. If not, display error message and  
    	//don't include project grade in course grade
    	if (value<0 || value > maxValue)
    	{
    		errorMessage =String.format("Grade should be between 0% and %d."+ " Invalid grade: %.02f",maxValue, value); 
    				
    		value = 0;
    	}
    	return errorMessage; 
	
	}
	
}
