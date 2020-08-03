package org.hexrobot.fe5randomizer.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hexrobot.fe5randomizer.Rom;

import javafx.beans.binding.IntegerBinding;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SectionsController {
    private static final int SEED_MAX_VALUE = 32;
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
    private TabPane tabPane;
    @FXML
    private Tab tabLilManster;
    @FXML
    private Tab tabExile;
    @FXML
    private Tab tabRandomize;
    @FXML
    private UnitsController unitsController;
    @FXML
    private RandomizeController randomizeController;
    
    @FXML
    private void initialize() {
        List<Integer> values = IntStream.range(0, SEED_MAX_VALUE).boxed().collect(Collectors.toList());
        
        cbSeed1.getItems().addAll(values);
        cbSeed2.getItems().addAll(values);
        cbSeed3.getItems().addAll(values);
        cbSeed4.getItems().addAll(values);
        
        cbSeed1.getSelectionModel().selectFirst();
        cbSeed2.getSelectionModel().selectFirst();
        cbSeed3.getSelectionModel().selectFirst();
        cbSeed4.getSelectionModel().selectFirst();
        
        IntegerBinding seed = new IntegerBinding() {
            {
                super.bind(cbSeed1.valueProperty(), cbSeed2.valueProperty(), cbSeed3.valueProperty(), cbSeed4.valueProperty());
            }
            
            @Override
            protected int computeValue() {
                int[] values = new int[4];
                
                values[0] = cbSeed1.valueProperty().getValue();
                values[1] = cbSeed2.valueProperty().getValue();
                values[2] = cbSeed3.valueProperty().getValue();
                values[3] = cbSeed4.valueProperty().getValue();
                
                return (values[0] << 15) | (values[1] << 10) | (values[2] << 5) | values[3];
            }
            
        };
        
        MainController.getInstance().getRandomizeSummary().seedProperty().bind(seed);
    }

    @FXML
    private void generateRandomSeed() {
        cbSeed1.getSelectionModel().select((int) (Math.random() * SEED_MAX_VALUE));
        cbSeed2.getSelectionModel().select((int) (Math.random() * SEED_MAX_VALUE));
        cbSeed3.getSelectionModel().select((int) (Math.random() * SEED_MAX_VALUE));
        cbSeed4.getSelectionModel().select((int) (Math.random() * SEED_MAX_VALUE));
    }

    public void setRom(Rom rom, Stage stage) {
        stage.setResizable(true);
        lblTitle.setText(String.format("%s %s", rom.getName(), rom.isHeadered() ? "(Headered)" : "(Headerless)"));
        lblBytes.setText(String.format("%d bytes", rom.getSize()));
        lblChecksum.setText(Long.toHexString(rom.getCrc32Checksum()));
        
        if(!rom.isLilMansterHack()) {
            tabPane.getTabs().remove(tabLilManster);
        }
        
        if(!rom.isProjectExileHack()) {
            tabPane.getTabs().remove(tabExile);
        }
        
        randomizeController.setRom(rom);
    }
    
    public long getSeed() {
        long seed = (cbSeed1.getValue() << 15) + (cbSeed2.getValue() << 10) + (cbSeed3.getValue() << 5) + cbSeed4.getValue();
        System.out.println(String.format("Seed: %12X", seed));
        return seed;
    }
    
    public String getSelectedTab() {
        return (String)tabPane.getSelectionModel().getSelectedItem().getUserData();
    }
    
    public void setRandomizeTab() {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(tabRandomize);
    }
    
    public RandomizeController getRandomizeController() {
        return randomizeController;
    }
}
