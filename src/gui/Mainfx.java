package gui;

import java.io.IOException;
import eg.edu.alexu.csd.oop.calculator.*;
import eg.edu.alexu.csd.oop.calculator.cs44.Project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mainfx extends Application {
	
     //Calculator calc;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Calc.fxml"));
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(new Scene(root));
		//calc = new Project();
		//Control c = new Control(calc);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
