package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.RomValidity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadRomController {
    @FXML
    private HBox loadRom;
	@FXML
	private Button btnLoadRom;

	private Stage stage;
	private Rom rom;
	
	public void setStage(Stage stage) {
	    this.stage = stage;
	}

	@FXML
	private void openFileDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Fire Emblem 5 Rom file");
		fileChooser.setInitialDirectory(new File("/home/hexrobot/Downloads/"));
		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
		File selectedFile = fileChooser.showOpenDialog(btnLoadRom.getScene().getWindow());

		Alert alert = new Alert(AlertType.ERROR);
		RomValidity romValidity = null;

		if(selectedFile != null) {
			try {
				romValidity = isValidRom(selectedFile);
			} catch(IOException e) {
				e.printStackTrace();
				romValidity = RomValidity.ERROR;
			}

			if(romValidity.equals(RomValidity.FE5_HEADERED) || romValidity.equals(RomValidity.FE5_UNHEADERED)) {
			    rom.initializeItems();
			    rom.initializeCharacters();
			    
			    try {
			        goToSectionsScene();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			} else {
				switch(romValidity) {
				case NO_FE5:
					alert.setContentText("Only Fire Emblem 5 is supported.");
					break;
				case FAILS_CHECKSUM:
					alert.setContentText("Only unpatched versions of Fire Emblem 5 are supported.");
					break;
				case ERROR:
					alert.setContentText("The file was not found.");
					break;
				default:
					break;
				}

				alert.show();
			}
		}
	}

	private RomValidity isValidRom(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		rom = new Rom(inputStream.readAllBytes());
		inputStream.close();

		return rom.getRomValidity();
	}
	
	private void goToSectionsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Sections.fxml"));
        Parent vBox = loader.load();
        SectionsController sectionsController = loader.getController();
        sectionsController.setRom(rom);
        
        Scene sectionsScene = new Scene(vBox);
        stage.setScene(sectionsScene);
        stage.setResizable(true);
	}
}
