package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import org.hexrobot.fe5randomizer.LoadRomService;
import org.hexrobot.fe5randomizer.Rom;
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
    private void openFileDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Fire Emblem 5 Rom file");
        fileChooser.setInitialDirectory(new File("/home/hexrobot/Downloads/"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
        File selectedFile = fileChooser.showOpenDialog(btnLoadRom.getScene().getWindow());

        if(selectedFile != null) {
            LoadRomService loadRomService = new LoadRomService(selectedFile);

            Label label = mainController.getStatusLabel();
            ProgressBar progressBar = mainController.getProgressBar();

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

        }
    }

    private void evaluateRom(Rom rom) {
        System.out.println(rom);
        
        if(rom.isFireEmblem5()) {
            MainController.rom = rom;
            mainController.switchToSectionsController(rom);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("The selected file is not a Fire Emblem 5 Rom.");
            alert.show();
        }
    }
}
