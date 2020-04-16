package org.hexrobot.fe5randomizer;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainView extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
		/*VBox nn = new VBox();
		nn.getChildren().add(new Label("Caca"));*/
		
		//Parent root = nn;
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Welcome");
        primaryStage.show();
	}

}
