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
	
	@Override
	public void start(Stage primaryStage) throws IOException, ParserConfigurationException, TransformerException, NoSuchAlgorithmException {
		
		ArrayList<User> users = new ArrayList<User>();
		MessageDigest md = MessageDigest.getInstance("MD5");
		users.add(new Admin());
		users.get(0).setfName("Leeroy");
		users.get(0).setmInitial("D");
		users.get(0).setlName("Jenkins");
		users.get(0).setUserID("ADMIN_Jenkins");
		users.get(0).setPassword(md.digest("password123".getBytes("UTF-8")));
		users.get(0).setAddress("7121 Bishop Rd");
		users.get(0).setCity("Plano");
		users.get(0).setState("TX");
		users.get(0).setZip("75024");
		users.get(0).setEmail("ADMIN_Jenkins@helpme.org");
		users.get(0).setPhone("123-456-7890");
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
