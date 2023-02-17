package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginController {
	
	@FXML
	TextField usernameField;
	
	public void pressButt(ActionEvent e) {
		System.out.println(usernameField.getText());
	}
}
