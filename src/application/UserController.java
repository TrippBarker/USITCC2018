package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserController {
	@FXML
	Button printUser;
	
	SceneSwitcher ss = new SceneSwitcher();
	
	public void printUser() {
		System.out.println(Main.user.toString());
	}
	
	public void userLogout(ActionEvent e) throws IOException {
		ss.switchScene(e, "scenes/LoginScene.fxml");
	}
}
