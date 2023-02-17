package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneSwitcher {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchScene(ActionEvent e, String fileName) throws IOException {
		root = FXMLLoader.load(getClass().getResource(fileName));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
