package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegisterController {
	
	@FXML
	TextField fNameField, 
			  mInitialField, 
			  lNameField, 
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
	public void initialize() {
		stateField.getItems().removeAll(stateField.getItems());
		stateField.getItems().addAll("GA", "TX", "CA");
	}
	
	
}
