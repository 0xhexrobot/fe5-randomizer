package org.hexrobot.fe5randomizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

import org.hexrobot.fe5randomizer.items.Item;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class LoadRomController {
	@FXML
	private Button btnLoadRom;

	private Rom rom;

	@FXML
	private void openFileDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Fire Emblem 5 ROM file");
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
			    //rom.initializeItems();
			    rom.initializeCharacters();
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
}
