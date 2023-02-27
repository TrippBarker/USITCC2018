package application;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	public static ArrayList<User> users;
	
	@Override
	public void start(Stage primaryStage) throws IOException, ParserConfigurationException, TransformerException, NoSuchAlgorithmException {
		UserReader userReader = new UserReader();
		users = userReader.readXML();
		for (User user: users) {
			System.out.println(user.toString());
		}
		Parent root = FXMLLoader.load(getClass().getResource("scenes/LoginScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void addUser(User newUser) throws ParserConfigurationException, TransformerException {
		users.add(newUser);
		UserWriter userWriter = new UserWriter();
		userWriter.buildDocument(users);
	}
}
