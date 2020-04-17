package org.hexrobot.fe5randomizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class LoadRomController {
	@FXML
	private Button btnLoadRom;
	
	private byte[] rom = null;

	@FXML
	private void openFileDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Fire Emblem 5 ROM file");
		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
		File selectedFile = fileChooser.showOpenDialog(btnLoadRom.getScene().getWindow());

		Alert alert = new Alert(AlertType.ERROR);
		RomValidity romValidity = null;

		if(selectedFile != null) {
			try {
				romValidity = isValidRom(selectedFile);
			} catch(IOException e) {
				romValidity = RomValidity.ERROR;
			}

			if(romValidity.equals(RomValidity.FE5_UNHEADERED)) {
				System.out.println("Viento en las velas!!!");
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
		RomValidity romValidity = RomValidity.ERROR;
		
		InputStream inputStream = new FileInputStream(file);
		CRC32 crc32 = new CRC32();
		rom = inputStream.readAllBytes();
		
		crc32.update(rom);
		Long fileCrc32Checksum = crc32.getValue();
		
		System.out.println("Length: " + rom.length + " bytes");
		System.out.println("CRC32 checksum: " + fileCrc32Checksum);
		
		if(fileCrc32Checksum.equals(Constants.FE5_HEADERED_CRC32_CHK)) {
			System.out.println("Fire Emblem 5 headered");
			romValidity = RomValidity.FE5_HEADERED;
		} else if(fileCrc32Checksum.equals(Constants.FE5_UNHEADERED_CRC32_CHK)) {
			System.out.println("Fire Emblem 5 unheadered");
			romValidity = RomValidity.FE5_UNHEADERED;
		}
		
		inputStream.close();

		return romValidity;
	}

	private enum RomValidity {
		FE5_HEADERED, FE5_UNHEADERED, NO_FE5, FAILS_CHECKSUM, ERROR
	}
}
