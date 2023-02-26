package application;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		  stateError,
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
		stateField.getItems().addAll("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA",
									 "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", 
									 "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
									 "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", 
									 "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
	}
	
	String[] userVariables = {"", "", "", "", "", "", "", "", "", "", ""};
	
	private SceneSwitcher ss = new SceneSwitcher();
	
	public void checkForValidFields(ActionEvent e) throws IOException, NoSuchAlgorithmException{
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
		if (userIDField.getText().length() < 5) {
			haveValidFields = false;
			idError.setText("ID should be at least 5 chars");
			idError.setVisible(true);
		} else {
			idError.setVisible(false);
		}
		if (passwordField.getText().length() < 8) {
			haveValidFields = false;
			passwordError.setVisible(true);
		} else {
			passwordError.setVisible(false);
		}
		if (!conPasswordField.getText().equals(passwordField.getText())) {
			haveValidFields = false;
			conPasswordError.setVisible(true);
		} else {
			conPasswordError.setVisible(false);
		}
		if (cityField.getText().length() < 3) {
			haveValidFields = false;
			cityError.setVisible(true);
		} else {
			cityError.setVisible(false);
		}
		if (zipField.getText().length() != 5) {
			haveValidFields = false;
			zipError.setVisible(true);
		} else {
			zipError.setVisible(false);
		}
		if (addressField.getText().length() < 5) {
			haveValidFields = false;
			addressError.setVisible(true);
		} else {
			addressError.setVisible(false);
		}
		if (phoneField.getText().length() != 10) {
			haveValidFields = false;
			phoneError.setVisible(true);
		} else {
			phoneError.setVisible(false);
		}
		if (emailField.getText().length() < 5) {
			haveValidFields = false;
			emailError.setVisible(true);
		} else {
			emailError.setVisible(false);
		}
		if (stateField.getValue() == null) {
			haveValidFields = false;
			stateError.setVisible(true);
		} else {
			stateError.setVisible(false);
		}
		if(haveValidFields) {
			createNewUser(e);
		}
	}
	
	public void switchToLoginScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/LoginScene.fxml");
	}
	
	public void switchToUserScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/UserScene.fxml");
	}
	
	public void checkValidChar(KeyEvent ke){
		System.out.println(ke.getCharacter());
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
			pattern = "[A-Za-z-\b]";
			varIndex = 2;
			break;
		case "userIDField":
			len = 15;
			pattern = "[A-Za-z0-9\b]";
			varIndex = 3;
			break;
		case "passwordField":
			len = 16;
			pattern = "[A-Za-z0-9-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/\b]";
			varIndex = 4;
			break;
		case "conPasswordField":
			len = 16;
			pattern = "[A-Za-z0-9-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/\b]";
			varIndex = 5;
			break;
		case "cityField":
			len = 10;
			pattern = "[A-Za-z \b]";
			varIndex = 6;
			break;
		case "zipField":
			len = 5;
			pattern = "[0-9\b]";
			varIndex = 7;
			break;
		case "addressField":
			len = 20;
			pattern = "[A-Za-z0-9 \b]";
			varIndex = 8;
			break;
		case "emailField":
			len = 25;
			pattern = "[A-Za-z@.\b]";
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
	
	public void createNewUser(ActionEvent e) throws IOException, NoSuchAlgorithmException {
		Main.user = new Volunteer();
		MessageDigest md = MessageDigest.getInstance("MD5");
		Main.user.setfName(fNameField.getText());
		Main.user.setmInitial(mInitialField.getText());
		Main.user.setlName(lNameField.getText());
		Main.user.setUserID(userIDField.getText());
		Main.user.setPassword(md.digest(passwordField.getText().getBytes("UTF-8")));
		Main.user.setAddress(addressField.getText());
		Main.user.setCity(cityField.getText());
		Main.user.setState(stateField.getValue());
		Main.user.setZip(Integer.valueOf(zipField.getText()));
		Main.user.setEmail(emailField.getText());
		Main.user.setPhone(phoneField.getText());
		for(int i = 0; i < Main.user.getPassword().length; i++) {
			System.out.print(Main.user.getPassword()[i]);
		}
		switchToUserScene(e);
	}
	
}
