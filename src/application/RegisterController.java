package application;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class RegisterController {
	
	@FXML
	Label fNameError,
		  lNameError,
		  addressError,
		  cityError,
		  zipError,
		  idError,
		  passwordError,
		  conPasswordError,
		  emailError,
		  phoneError;
	
	@FXML
	TextField fNameField, 
			  mInitialField, 
			  lNameField,
			  userIDField,
			  passwordField, 
			  conPasswordField, 
			  cityField, 
			  zipField, 
			  phoneField, 
			  emailField, 
			  addressField;
	
	@FXML
	ComboBox<String> stateField;
	
	@FXML
	Button backButton, submitButton;
	
	@FXML
	public void initialize() {
		stateField.getItems().removeAll(stateField.getItems());
		stateField.getItems().addAll("GA", "TX", "CA");
	}
	
	String[] userVariables = {"", "", "", "", "", "", "", "", "", "", ""};
	
	private SceneSwitcher ss = new SceneSwitcher();
	
	public void checkForValidFields(ActionEvent e) throws IOException{
		boolean haveValidFields = true;
		if (fNameField.getText().equals("")) {
			haveValidFields = false;
			fNameError.setVisible(true);
		} else {
			fNameError.setVisible(false);
		}
		if (lNameField.getText().equals("")) {
			haveValidFields = false;
			lNameError.setVisible(true);
		} else {
			lNameError.setVisible(false);
		}
	}
	
	public void switchToLoginScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/LoginScene.fxml");
	}
	
	public void switchToUserScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/UserScene.fxml");
	}
	
	public void checkValidChar(KeyEvent ke){
		int len;
		String pattern;
		int varIndex;
		TextField field = (TextField)ke.getSource();
		switch (field.getId()) {
		case "fNameField":
			len = 15;
			pattern = "[A-Za-z\b]";
			varIndex = 0;
			break;
		case "mInitialField":
			len = 1;
			pattern = "[A-Za-z\b]";
			varIndex = 1;
			break;
		case "lNameField":
			len = 15;
			pattern = "[A-Za-z\b]";
			varIndex = 2;
			break;
		case "userIDField":
			len = 15;
			pattern = "[A-Za-z\b]";
			varIndex = 3;
			break;
		case "passwordField":
			len = 16;
			pattern = "[A-Za-z0-9\b]";
			varIndex = 4;
			break;
		case "conPasswordField":
			len = 16;
			pattern = "[A-Za-z0-9\b]";
			varIndex = 5;
			break;
		case "cityField":
			len = 10;
			pattern = "[A-Za-z\b]";
			varIndex = 6;
			break;
		case "zipField":
			len = 5;
			pattern = "[0-9\b]";
			varIndex = 7;
			break;
		case "addressField":
			len = 20;
			pattern = "[A-Za-z0-9\b]";
			varIndex = 8;
			break;
		case "emailField":
			len = 25;
			pattern = "[A-Za-z\b]";
			varIndex = 9;
			break;
		case "phoneField":
			len = 10;
			pattern = "[0-9\b]";
			varIndex = 10;
			break;
		default:
			len = 10;
			pattern = "[A-Za-z\b]";
			varIndex = 0;
			break;
		}
		
		if (!Pattern.matches(pattern, ke.getCharacter()) || (userVariables[varIndex].length() == len && !ke.getCharacter().equals("\b"))) {
			field.setText(userVariables[varIndex]);
			field.positionCaret(userVariables[varIndex].length());
		} else {
			userVariables[varIndex] = field.getText();
		}
	}
	
}
