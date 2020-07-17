package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.service.LoadRomService;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

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
    public void openFileDialog() {
        FileChooser fileChooser = new FileChooser();
        File file = new File(MainController.CONFIG_FILENAME);
        Properties properties = new Properties();
        String lastDirectory;
        
        if(file.exists()) {
            try {
                properties = MainController.readPropertiesFile(MainController.CONFIG_FILENAME);
                lastDirectory = properties.getProperty("lastDirectory", "");
                
                if(!lastDirectory.isEmpty()) {
                    fileChooser.setInitialDirectory(new File(lastDirectory));
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        fileChooser.setTitle("Select Fire Emblem 5 Rom file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
        File selectedFile = fileChooser.showOpenDialog(btnLoadRom.getScene().getWindow());

        if(selectedFile != null) {
            LoadRomService loadRomService = new LoadRomService(selectedFile);

            Label label = mainController.getStatusLabel();
            ProgressBar progressBar = mainController.getProgressBar();
            
            properties.setProperty("lastDirectory", selectedFile.getParent());
            
            try {
                properties.store(new FileOutputStream(MainController.CONFIG_FILENAME), null);
            } catch(IOException e) {
                e.printStackTrace();
            }

            label.textProperty().bind(loadRomService.messageProperty());
            label.visibleProperty().bind(loadRomService.runningProperty());
            progressBar.progressProperty().bind(loadRomService.progressProperty());
            progressBar.visibleProperty().bind(loadRomService.runningProperty());
            btnLoadRom.disableProperty().bind(loadRomService.runningProperty());

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
                    btnLoadRom.disableProperty().unbind();
                    btnLoadRom.setDisable(false);

                    evaluateRom(loadRomService.getValue());
                }
            });

            loadRomService.setOnFailed(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent arg0) {
                    Throwable throwable = loadRomService.getException(); 
                    throwable.printStackTrace();
                }
            });
        }
    }

    private void evaluateRom(Rom rom) {
        System.out.println(rom);
        
        if(rom.isFireEmblem5()) {
            mainController.setRom(rom);
            mainController.switchToSectionsController(rom);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("The selected file is not a Fire Emblem 5 Rom.");
            alert.show();
        }
    }
}
