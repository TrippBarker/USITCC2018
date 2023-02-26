module USITCC2018 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
}
