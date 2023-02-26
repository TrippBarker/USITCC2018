package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static User user;
	
	@Override
	public void start(Stage primaryStage) throws IOException, ParserConfigurationException, TransformerException {
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(new Volunteer());
		users.add(new Volunteer());
		users.add(new Volunteer());
		users.get(0).setfName("Bob");
		users.get(0).setUserID("HiImBob123");
		users.get(0).setPhone("1234567891");
		users.get(1).setfName("Catherine");
		users.get(1).setUserID("ILikeCats");
		users.get(1).setPhone("4047712312");
		users.get(2).setfName("Alexia");
		users.get(2).setUserID("xXxAlexiaxXx");
		users.get(2).setPhone("8675305");
		
		UserWriter userWriter = new UserWriter();
		userWriter.buildDocument(users);
		
		Parent root = FXMLLoader.load(getClass().getResource("scenes/LoginScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
