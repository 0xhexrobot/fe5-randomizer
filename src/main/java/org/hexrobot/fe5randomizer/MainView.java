package org.hexrobot.fe5randomizer;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
				
		primaryStage.setScene(scene);
        primaryStage.setTitle("Fire Emblem 5 Randomizer");
        primaryStage.show();
	}
}
