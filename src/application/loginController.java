package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	
	public void pressButt(ActionEvent e) {
		System.out.println("USER: " + usernameField.getText());
		System.out.println("PASS: " + passwordField.getText());
	}
}
