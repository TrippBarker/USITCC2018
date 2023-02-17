package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	Button backButton, submitButton;
	
	@FXML
	public void initialize() {
		stateField.getItems().removeAll(stateField.getItems());
		stateField.getItems().addAll("GA", "TX", "CA");
	}
	
	private SceneSwitcher ss = new SceneSwitcher();
	
	public void switchToLoginScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/LoginScene.fxml");
	}
	
	public void switchToUserScene(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/UserScene.fxml");
	}
	
}
