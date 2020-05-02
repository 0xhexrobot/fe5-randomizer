package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import java.io.IOException;
import org.hexrobot.fe5randomizer.LoadRomService;
import org.hexrobot.fe5randomizer.Rom;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadRomController {
    @FXML
    private HBox loadRom;
    @FXML
    private Button btnLoadRom;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
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

        if(selectedFile != null) {
            LoadRomService loadRomService = new LoadRomService(selectedFile);

            Label label = mainController.getStatusLabel();
            ProgressBar progressBar = mainController.getProgressBar();

            label.textProperty().bind(loadRomService.messageProperty());
            label.visibleProperty().bind(loadRomService.runningProperty());
            progressBar.progressProperty().bind(loadRomService.progressProperty());
            progressBar.visibleProperty().bind(loadRomService.runningProperty());

            loadRomService.start();

            loadRomService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

                @Override
                public void handle(WorkerStateEvent event) {
                    label.textProperty().unbind();
                    label.visibleProperty().unbind();
                    label.setVisible(false);
                    progressBar.progressProperty().unbind();
                    progressBar.visibleProperty().unbind();
                    progressBar.setVisible(false);
                    
                    Rom rom = loadRomService.getValue();
                    System.out.println(rom);
                    mainController.switchToSectionsController(rom);
                }
            });

            /*
             * try { romValidity = isValidRom(selectedFile); } catch(IOException e) {
             * e.printStackTrace(); romValidity = RomValidity.ERROR; }
             * 
             * if(romValidity.equals(RomValidity.FE5_HEADERED) ||
             * romValidity.equals(RomValidity.FE5_UNHEADERED)) { rom.initializeItems();
             * rom.initializeCharacters();
             * 
             * try { goToSectionsScene(); } catch (IOException e) { e.printStackTrace(); } }
             * else { switch(romValidity) { case NO_FE5:
             * alert.setContentText("Only Fire Emblem 5 is supported."); break; case
             * FAILS_CHECKSUM: alert.
             * setContentText("Only unpatched versions of Fire Emblem 5 are supported.");
             * break; case ERROR: alert.setContentText("The file was not found."); break;
             * default: break; }
             * 
             * alert.show();
             */
        }
    }
}
