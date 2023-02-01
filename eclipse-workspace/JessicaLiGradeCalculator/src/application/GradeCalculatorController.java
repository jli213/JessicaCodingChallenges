package application;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GradeCalculatorController {
	

    @FXML
    private TextField projectGradeTextField;

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoiceBox;

    @FXML
    private Slider quizSlider;
    
    @FXML
    private Label courseGradeLabel;

    @FXML
    void calculateGrade(ActionEvent event) {
    	
    	double courseGrade = 0.0;
    	
    	String projectGrade = projectGradeTextField.getText();
    	courseGrade = Double.parseDouble(projectGrade)*0.5;
    	System.out.println("Project grade entered: " + projectGrade +
    			" Course grade so far: " + courseGrade);
    	
    	
    	double quizGrade = quizSlider.getValue();
    	courseGrade += quizGrade*10*0.25;
    	System.out.println("Quiz grade entered: " + quizGrade +
    			" Course grade so far: " + courseGrade);
    	int requiredCodingChallengesPassed = requiredCodingChallengesChoiceBox.getValue();
    	courseGrade += (requiredCodingChallengesPassed*100/15)*0.25*15/20;
    	System.out.println("Required coding challenges passed: " + requiredCodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	
    	int optionalCodingChallengesPassed = optionalCodingChallengesChoiceBox.getValue();
    	courseGrade += (optionalCodingChallengesPassed*100/5)*0.25*5/20;
    	System.out.println("Optional coding challenges passed: " + optionalCodingChallengesPassed +
    			" Course grade so far: " + courseGrade);
    	
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
    }

}

