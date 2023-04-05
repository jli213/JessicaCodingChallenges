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
	
//	public Grade(String gradeValue, int maxGradeValue, double weightTowardsCourseGrade) throws InvalidGradeException {
//		int counter = 0;
//		for (char c : gradeValue.toCharArray()) {
//			if(!Character.isDigit(c)) {
//			
//				if(c =='.') {
//        			if(counter==0)
//        			{
//        				counter +=1;
//        				validGrade = true;
//        			}
//    			}
//			}
//		}
//		
//		try {
//			Double.parseDouble(gradeValue);
//		} catch (Exception e) {
//			throw new InvalidGradeException("Invalid grade value.Can not convert string to double");
//		}
		
		
		
	

	/**
	 * used for calculating the weighted percentage value of grades
	 * @return the weighted percentage value of grades
	 */
	double getWeightedPercentageValue(){
		return value *100 *weight /maxValue;
	}
	
	//actions

	public Grade(String gradeValue, int maxGradeValue, double weightTowardsCourseGrade) throws InvalidGradeException{
		maxValue = maxGradeValue;
		weight = weightTowardsCourseGrade;
    	boolean validGrade = true;
    	int counter =0; //set counter of number of character decimal to 0
    	
    	for (char c : gradeValue.toCharArray()) {
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
    				throw new InvalidGradeException(String.format("Don't include the character %c." +  
        					" Project Grade should be percentage." , c));
				}
    		}
    	}
    	
    	//Default project grade to 0. If valid number entered, convert input to 
    	//floating point number.
    	
    	
    	if(validGrade)
    	{
    		System.out.println("grade value"+gradeValue);
    		value = Double.parseDouble(gradeValue);	
    		System.out.println(value);
    	}
    	//Check if user entered a percentage grade. If not, display error message and  
    	//don't include project grade in course grade
    	if (value<0 || value > maxValue)
    	{
    		value = 0;
    		throw new InvalidGradeException(String.format("Grade should be between 0 and %d. Invalid grade: %.02f",maxValue, value)); 
    	} 
	}

	public double getWeightedPercentageGrade() {
		// TODO Auto-generated method stub
		return value *100 *weight /maxValue;
	}


	
}
