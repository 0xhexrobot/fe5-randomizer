package org.hexrobot.fe5randomizer;

import java.io.IOException;

import org.hexrobot.fe5randomizer.controllers.LoadRomController;

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
	    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("LoadRom.fxml"));
	    Parent root = loader.load();
		Scene loadRomScene = new Scene(root);
		LoadRomController loadRomController = loader.getController();
		
		loadRomController.setStage(primaryStage);
		primaryStage.setScene(loadRomScene);
        primaryStage.setTitle("FE 5 Randomizer");
        primaryStage.setResizable(false);
        primaryStage.show();
	}
}
