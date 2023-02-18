package application;




import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeCalculatorController {
	Stage applicationStage;
	double requiredQuizAverageGrade = 0.0;
	double optionalQuizAverageGrade = 0.0;

    @FXML
    private TextField projectGradeTextField;

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> optionalQuizzesChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> requiredQuizzesChoiceBox;
    
    @FXML
    private Label requiredQuizAverageGradeLabel;
    
    @FXML
    private Label optionalQuizAverageGradeLabel;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML
    private Label projectGradeErrorLabel;
    
    /**
     * Checks if the value provided is a valid project grade. A project grade must be numeric and 
     * a percentage(between 0 and 100) and it can be a real number(having digits). 
     * If valid, the equivalent double is returned, if not this method returns a zero.
     * 
     * @param valueEntered the value entered as the project grade
     * @return the double value of valueEntered if it is numeric and a valid percentage and 0 otherwise
     */
    
    double getProjectGrade(String valueEntered) {
    	
    	boolean validProjectGrade = true;
    	int counter =0; //set counter of number of character decimal to 0
    	
    	
    	for (char c : valueEntered.toCharArray()) {
    		if(!Character.isDigit(c)) {
    			//if any number is not a digit or is not a real number, set flag to false, it is not a number
    			validProjectGrade = false;
    			//check if value entered has decimals and see if it is a real number
    			if(c =='.') {
        			if(counter==0)
        			{
        				counter +=1;
        				validProjectGrade = true;
        			}
    			}
    			if(!validProjectGrade)
				{
					projectGradeErrorLabel.setText("Don't include the character : "+c
        					+". Project Grade should be percentage.");
				}
    		}
    	}
    	
    	//Default project grade to 0. If valid number entered, convert input to 
    	//floating point number.
    	double projectGrade = 0;
    	if(validProjectGrade)
    	{
    		projectGrade = Double.parseDouble(projectGradeTextField.getText());	
    	}
    	
    	//Check if user entered a percentage grade. If not, display error message and  
    	//don't include project grade in course grade
    	if (projectGrade<0 || projectGrade >100)
    	{
    		projectGradeErrorLabel.setText("Project Grade should be between 0% and 100%. Invalid project grade:" 
    				+ projectGrade);
    		projectGrade = 0;
    	}
    	
    	return projectGrade;
    }
    
    void calculateOptionalQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields )
    {
    	optionalQuizAverageGrade = 0;
    	double quizGrade;
    	for(TextField textfield:quizGradeTextFields) {
    		quizGrade = Double.parseDouble(textfield.getText());
    		optionalQuizAverageGrade += quizGrade;
    			
    	}
    	optionalQuizAverageGrade = optionalQuizAverageGrade/5;

    	applicationStage.setScene(mainScene);
    	optionalQuizAverageGradeLabel.setText(Double.toString(optionalQuizAverageGrade));
    }
    
    @FXML
    void getOptionalQuizGrades(ActionEvent enterQuizGradesEvent) {
    	Scene mainScene =  applicationStage.getScene();
    	
    	int numberOfQuizzes = optionalQuizzesChoiceBox.getValue();
    	
    	int rowCounter = 0;
    	VBox allRows = new VBox();
    	Label quizType = new Label("Optional Quiz grades");
    	allRows.getChildren().add(quizType);
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	while(rowCounter<numberOfQuizzes) {
    		rowCounter++;
    		HBox quizRow = new HBox();
    		
        	Label quizLabel = new Label("Quiz " + rowCounter +" grade");
        	TextField quizGradeTextField = new TextField();
        	quizTextFields.add(quizGradeTextField);
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextField);        	
        	
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateOptionalQuizGrade(mainScene, quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    }
    
    void calculateRequiredQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields )
    {
    	requiredQuizAverageGrade = 0;
    	for(TextField textfield:quizGradeTextFields) {
    		requiredQuizAverageGrade += Double.parseDouble(textfield.getText());
    		
    	}
    	requiredQuizAverageGrade = requiredQuizAverageGrade/15;
    	
    	applicationStage.setScene(mainScene);
    	requiredQuizAverageGradeLabel.setText(Double.toString(requiredQuizAverageGrade));

    }
    
    
    @FXML
    void getRequiredQuizGrades(ActionEvent enterQuizGradesEvent) {
    	Scene mainScene =  applicationStage.getScene();
    	
    	int numberOfQuizzes = requiredQuizzesChoiceBox.getValue();
    	
    	int rowCounter = 0;
    	VBox allRows = new VBox();
    	Label quizType = new Label("Required Quiz grades");
    	allRows.getChildren().add(quizType);
    	ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
    	while(rowCounter<numberOfQuizzes) {
    		rowCounter++;
    		HBox quizRow = new HBox();
    		
        	Label quizLabel = new Label("Quiz " + rowCounter +" grade");
        	TextField quizGradeTextField = new TextField();
        	quizTextFields.add(quizGradeTextField);
        	quizRow.getChildren().addAll(quizLabel,quizGradeTextField);        	
        	
        	allRows.getChildren().add(quizRow);
    	}
    	Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateRequiredQuizGrade(mainScene, quizTextFields));
    	allRows.getChildren().add(doneButton);
    	
    	
    	Scene quizScene = new Scene(allRows);
    	applicationStage.setScene(quizScene);
    }
    
    
    
    @FXML
    void calculateGrade(ActionEvent event) {
    	projectGradeErrorLabel.setText("");
    	double courseGrade = 0.0;
    	
    	String projectValueEntered = projectGradeTextField.getText();
    	
    	//use function and return project grade
    	double projectGrade = getProjectGrade(projectValueEntered);
    	//calculate course grade when project grade weighs 0.4
    	courseGrade = projectGrade*0.4;
    	
    	System.out.println("Project grade entered: " + projectGrade +
    			" Course grade so far: " + courseGrade);
    	
    	//calculate course grade when quiz grade weighs 0.3
    	double requiredQuizGrade = requiredQuizAverageGrade;
    	courseGrade += (requiredQuizGrade*10)*0.3*15/20;
    	System.out.println("Quiz grade entered: " + requiredQuizGrade +
    			" Course grade so far: " + courseGrade);
    	double optionalQuizGrade = optionalQuizAverageGrade;
    	courseGrade += (optionalQuizGrade*10)*0.3*5/20;
    	System.out.println("Quiz grade entered: " + optionalQuizGrade +
    			" Course grade so far: " + courseGrade);
    	
    	
    	//calculate course grade when total coding challenges weigh+s 0.3
    	int requiredCodingChallengesPassed = requiredCodingChallengesChoiceBox.getValue();
    	courseGrade += (requiredCodingChallengesPassed*100/15)*0.3*15/20;
    	System.out.println("Required coding challenges passed: " + requiredCodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	//calculate course grade when total coding challenges weighs 0.3
    	int optionalCodingChallengesPassed = optionalCodingChallengesChoiceBox.getValue();
    	courseGrade += (optionalCodingChallengesPassed*100/5)*0.3*5/20;
    	System.out.println("Optional coding challenges passed: " + optionalCodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    }

}

