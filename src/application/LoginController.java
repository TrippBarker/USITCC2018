package application;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class LoginController {
	
	private SceneSwitcher ss = new SceneSwitcher();
	private String lastTypedUsername = "";
	
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	
	public void userLogin(ActionEvent e) throws IOException {
		System.out.println("USER: " + usernameField.getText());
		System.out.println("PASS: " + passwordField.getText());
		ss.switchScene(e, "scenes/RegisterScene.fxml");
	}
	
	public void checkValidChar(KeyEvent ke){
		System.out.println(ke.getCharacter());
		if (!Pattern.matches("[A-Za-z\b]", ke.getCharacter()) || (lastTypedUsername.length() == 15 && !ke.getCharacter().equals("\b"))) {
			usernameField.setText(lastTypedUsername);
			usernameField.positionCaret(lastTypedUsername.length());
		} else {
			lastTypedUsername = usernameField.getText();
		}
	}
}
