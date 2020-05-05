package org.hexrobot.fe5randomizer;

import java.io.IOException;

import org.hexrobot.fe5randomizer.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	    FXMLLoader mainLoader = new FXMLLoader(getClass().getClassLoader().getResource("Main.fxml"));
	    Parent root = mainLoader.load();
		Scene scene = new Scene(root);
		MainController mainController = mainLoader.getController();
		
		mainController.setStage(primaryStage);
		primaryStage.setScene(scene);
        primaryStage.setTitle("FE 5 Randomizer");
        primaryStage.setResizable(false);
        primaryStage.show();
	}
}
