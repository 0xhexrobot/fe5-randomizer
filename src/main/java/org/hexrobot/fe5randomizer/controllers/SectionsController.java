package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.Rom;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SectionsController {
    @FXML
    private VBox sections;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblBytes;
    @FXML
    private Label lblChecksum;
    @FXML
    private ComboBox<Integer> cbSeed1;
    @FXML
    private ComboBox<Integer> cbSeed2;
    @FXML
    private ComboBox<Integer> cbSeed3;
    @FXML
    private ComboBox<Integer> cbSeed4;
    @FXML
    private UnitsController unitsController;
    
    @FXML
    private void initialize() {
        cbSeed1.getSelectionModel().selectFirst();
        cbSeed2.getSelectionModel().selectFirst();
        cbSeed3.getSelectionModel().selectFirst();
        cbSeed4.getSelectionModel().selectFirst();
    }

    @FXML
    private void generateRandomSeed() {
        cbSeed1.getSelectionModel().select((int) (Math.random() * 16));
        cbSeed2.getSelectionModel().select((int) (Math.random() * 16));
        cbSeed3.getSelectionModel().select((int) (Math.random() * 16));
        cbSeed4.getSelectionModel().select((int) (Math.random() * 16));
    }

    public void setRom(Rom rom, Stage stage) {
        stage.setResizable(true);
        lblTitle.setText(String.format("%s %s", rom.getName(), rom.isHeadered() ? "Headered" : "Headerless"));
        lblBytes.setText(String.format("%d bytes", rom.getSize()));
        lblChecksum.setText("" + rom.getCrc32Checksum());
    }
}
