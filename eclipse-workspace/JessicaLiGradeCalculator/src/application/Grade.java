package application;

/**
 * each grade object has three variables:
 * the grade value, the maximum value for the grade 
 * and the weight of the grade.
 */
public class Grade {
	//attributes/data
	double value =0;
	double weight;
	int maxValue;
	
	/**
	 * constructor for Grade class
	 * @param gradeValue the value of the grade 
	 * @param maxGradeValue the maximum grade 
	 * @param weightTowardsCourseGrade the weight of the grade towards the course grade
	 */
	Grade(double gradeValue, int maxGradeValue, double weightTowardsCourseGrade) {
		value = gradeValue;
		maxValue = maxGradeValue;
		weight = weightTowardsCourseGrade;
	}
	
	/**
	 * used for calculating the weighted percentage value of grades
	 * @return the weighted percentage value of grades
	 */
	double getWeightedPercentageValue(){
		return value *100 *weight /maxValue;
	}
	
	//actions
	/**
	 * checks if the value entered is a valid digit and percentage and is between 0 and its maximum grade value
	 * returns a error message if grade is invalid, if not converts the grade value to a double
	 * @param valueAsString a string that contains the grade value
	 * @return errorMessage the error message when grade is invalid if grade is valid it returns an empty string
	 */
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
    	}
    	
    	//Check if user entered a percentage grade. If not, display error message and  
    	//don't include project grade in course grade
    	if (value<0 || value > maxValue)
    	{
    		errorMessage =String.format("Grade should be between 0 and %d. Invalid grade: %.02f",maxValue, value); 
    				
    		value = 0;
    	}
    	return errorMessage; 
	
	}
	
}
