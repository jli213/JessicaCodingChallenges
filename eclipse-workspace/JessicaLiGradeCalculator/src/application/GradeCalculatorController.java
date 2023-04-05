package application;

import java.util.ArrayList;

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
	Label quizGradeErrorLabel = new Label();

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
	 * Checks if the value provided is a valid project grade. A project grade must
	 * be numeric and a percentage(between 0 and 100) and it can be a real
	 * number(having digits). If valid, the equivalent double is returned, if not
	 * this method returns a zero. a
	 * 
	 * @param valueEntered the value entered as the project grade
	 * @return the double value of valueEntered if it is numeric and a valid
	 *         percentage and 0 otherwise
	 */

	double getProjectGrade(String valueEntered) {

		boolean validProjectGrade = true;
		int counter = 0; // set counter of number of character decimal to 0

		for (char c : valueEntered.toCharArray()) {
			if (!Character.isDigit(c)) {
				// if any number is not a digit or is not a real number, set flag to false, it
				// is not a number
				validProjectGrade = false;
				// check if value entered has decimals and see if it is a real number
				if (c == '.') {
					if (counter == 0) {
						counter += 1;
						validProjectGrade = true;
					}
				}
				if (!validProjectGrade) {
					projectGradeErrorLabel
							.setText("Don't include the character : " + c + ". Project Grade should be percentage.");
				}
			}
		}

		// Default project grade to 0. If valid number entered, convert input to
		// floating point number.
		double projectGrade = 0;
		if (validProjectGrade) {
			projectGrade = Double.parseDouble(projectGradeTextField.getText());
		}

		// Check if user entered a percentage grade. If not, display error message and
		// don't include project grade in course grade
		if (projectGrade < 0 || projectGrade > 100) {
			projectGradeErrorLabel
					.setText("Project Grade should be between 0% and 100%. Invalid project grade:" + projectGrade);
			projectGrade = 0;
		}

		return projectGrade;
	}
	void calculateOptionalQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields) {
		quizGradeErrorLabel.setText("");
		optionalQuizAverageGrade = 0;
		boolean noErrors = true;
		double weightOfEachQuiz = (1.0/5.0)/10.0;
		for (TextField textfield : quizGradeTextFields) {
			try {
				Grade quizGrade = new Grade(textfield.getText(),10,weightOfEachQuiz);
				optionalQuizAverageGrade += quizGrade.getWeightedPercentageValue();
			} catch (InvalidGradeException ige) {
				quizGradeErrorLabel.setText(ige.getMessage());
				Grade quizGrade = new Grade(0,10,weightOfEachQuiz);
				optionalQuizAverageGrade += quizGrade.getWeightedPercentageValue();
			}
			
		//	String errorMessage =  quizGrade.setValue(textfield.getText());
//			if(!errorMessage.equals("")) {
//				noErrors = false;
//				quizGradeErrorLabel.setText(errorMessage);
//			}
//			optionalQuizAverageGrade += quizGrade.getWeightedPercentageValue();

		}
		
		if(noErrors) {
			applicationStage.setScene(mainScene);
			optionalQuizAverageGradeLabel.setText(Double.toString(optionalQuizAverageGrade));
		}
		
		
	}

	@FXML
	void getOptionalQuizGrades(ActionEvent enterQuizGradesEvent) {
		Scene mainScene = applicationStage.getScene();

		int numberOfQuizzes = optionalQuizzesChoiceBox.getValue();

		int rowCounter = 0;
		VBox allRows = new VBox();
		Label quizType = new Label("Optional Quiz grades");
		allRows.getChildren().add(quizType);
		ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
		while (rowCounter < numberOfQuizzes) {
			rowCounter++;
			HBox quizRow = new HBox();

			Label quizLabel = new Label("Quiz " + rowCounter + " grade");
			TextField quizGradeTextField = new TextField();
			quizTextFields.add(quizGradeTextField);
			quizRow.getChildren().addAll(quizLabel, quizGradeTextField);

			allRows.getChildren().add(quizRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> calculateOptionalQuizGrade(mainScene, quizTextFields));
		allRows.getChildren().add(doneButton);
		allRows.getChildren().add(quizGradeErrorLabel);
		
		Scene quizScene = new Scene(allRows);
		applicationStage.setScene(quizScene);
	}

	void calculateRequiredQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields) {
		quizGradeErrorLabel.setText("");
		requiredQuizAverageGrade = 0;
		boolean noErrors = true;
		double weightOfEachQuiz = (1.0/15.0)/10.0;
		for (TextField textfield : quizGradeTextFields) {
			try {
				Grade quizGrade = new Grade(textfield.getText(),10,weightOfEachQuiz);
				requiredQuizAverageGrade += quizGrade.getWeightedPercentageValue();
			} catch (InvalidGradeException ige) {
				quizGradeErrorLabel.setText(ige.getMessage());
				Grade quizGrade = new Grade(0,10,weightOfEachQuiz);
				requiredQuizAverageGrade += quizGrade.getWeightedPercentageValue();
			}
//			String errorMessage =  quizGrade.setValue(textfield.getText());
//			if(!errorMessage.equals("")) {
//				noErrors = false;
//				quizGradeErrorLabel.setText(errorMessage);
//			}
//			
//
//		}
		if(noErrors) {
			applicationStage.setScene(mainScene);
			requiredQuizAverageGradeLabel.setText(Double.toString(requiredQuizAverageGrade));
		}
	}
	}
	
	

	@FXML
	void getRequiredQuizGrades(ActionEvent enterQuizGradesEvent) {
		Scene mainScene = applicationStage.getScene();

		int numberOfQuizzes = requiredQuizzesChoiceBox.getValue();

		int rowCounter = 0;
		VBox allRows = new VBox();
		Label quizType = new Label("Required Quiz grades");
		allRows.getChildren().add(quizType);
		ArrayList<TextField> quizTextFields = new ArrayList<TextField>();
		while (rowCounter < numberOfQuizzes) {
			rowCounter++;
			HBox quizRow = new HBox();

			Label quizLabel = new Label("Quiz " + rowCounter + " grade");
			TextField quizGradeTextField = new TextField();
			quizTextFields.add(quizGradeTextField);
			quizRow.getChildren().addAll(quizLabel, quizGradeTextField);

			allRows.getChildren().add(quizRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> calculateRequiredQuizGrade(mainScene, quizTextFields));
		allRows.getChildren().add(doneButton);
		allRows.getChildren().add(quizGradeErrorLabel);

		Scene quizScene = new Scene(allRows);
		applicationStage.setScene(quizScene);
	}

	@FXML
	void calculateGrade(ActionEvent event) {
		projectGradeErrorLabel.setText("");
		double courseGrade = 0.0;

		String projectValueEntered = projectGradeTextField.getText();
		try {
			Grade projectGrade = new Grade(projectValueEntered,100,0.4);
			Grade requiredQuizGrade = new Grade(requiredQuizAverageGrade,10,0.3 * 15 / 20);

			Grade optionalQuizGrade = new Grade(optionalQuizAverageGrade,10,0.3 * 5 / 20);

			Grade requiredCodingChallenges = new Grade(requiredCodingChallengesChoiceBox.getValue(),15,0.3 * 15 / 20);

			Grade optionalCodingChallenges = new Grade(optionalCodingChallengesChoiceBox.getValue(),5,0.3 * 5 / 20);

			
			courseGrade = projectGrade.getWeightedPercentageValue()
				  +requiredQuizGrade.getWeightedPercentageValue()
				  +optionalQuizGrade.getWeightedPercentageValue()
				  +requiredCodingChallenges.getWeightedPercentageValue()
				  +optionalCodingChallenges.getWeightedPercentageValue();
			courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
			 

		} catch (InvalidGradeException ige) {
			projectGradeErrorLabel.setText(ige.getMessage());
			Grade projectGrade = new Grade(0,100,0.4);
			Grade requiredQuizGrade = new Grade(requiredQuizAverageGrade,10,0.3 * 15 / 20);

			Grade optionalQuizGrade = new Grade(optionalQuizAverageGrade,10,0.3 * 5 / 20);

			Grade requiredCodingChallenges = new Grade(requiredCodingChallengesChoiceBox.getValue(),15,0.3 * 15 / 20);

			Grade optionalCodingChallenges = new Grade(optionalCodingChallengesChoiceBox.getValue(),5,0.3 * 5 / 20);

			
			courseGrade = projectGrade.getWeightedPercentageValue()
				  +requiredQuizGrade.getWeightedPercentageValue()
				  +optionalQuizGrade.getWeightedPercentageValue()
				  +requiredCodingChallenges.getWeightedPercentageValue()
				  +optionalCodingChallenges.getWeightedPercentageValue();
			courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade));
			 

		}
//		String errorMessage = projectGrade.setValue(projectValueEntered);
//		projectGradeErrorLabel.setText(errorMessage);

		
		/*
		 * courseGrade = projectGrade.getWeightedPercentageValue();
		 * 
		 * System.out.println("Project grade entered: " + projectGrade.value +
		 * " Course grade so far: " + courseGrade);
		 * 
		 * courseGrade += requiredQuizGrade.getWeightedPercentageValue();
		 * 
		 * System.out.println("Quiz grade entered: " + requiredQuizGrade.value +
		 * " Course grade so far: " + courseGrade);
		 * 
		 * courseGrade += optionalQuizGrade.getWeightedPercentageValue();
		 * 
		 * System.out.println("Quiz grade entered: " + optionalQuizGrade.value +
		 * " Course grade so far: " + courseGrade);
		 * 
		 * courseGrade += requiredCodingChallenges.getWeightedPercentageValue();
		 * 
		 * System.out.println("Required coding challenges passed: " +
		 * requiredCodingChallenges.value + " Course grade so far: " + courseGrade);
		 * 
		 * courseGrade += optionalCodingChallenges.getWeightedPercentageValue();
		 * 
		 * System.out.println("Optional coding challenges passed: " +
		 * optionalCodingChallenges.value + " Course grade so far: " + courseGrade);
		 */

		
	}

}
