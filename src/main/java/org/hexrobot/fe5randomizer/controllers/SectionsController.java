package org.hexrobot.fe5randomizer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.WeaponSeed;

import javafx.beans.binding.IntegerBinding;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private ComboBox<Integer> cbSeed5;
    @FXML
    private ComboBox<Integer> cbSeed6;
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
    private List<ComboBox<Integer>> cbSeeds = new ArrayList<>();
    
    @FXML
    private void initialize() {
        List<Integer> values = IntStream.range(0, SEED_MAX_VALUE).boxed().collect(Collectors.toList());
        
        cbSeeds.addAll(List.of(cbSeed1, cbSeed2, cbSeed3, cbSeed4, cbSeed5, cbSeed6));
        
        for(ComboBox<Integer> cb : cbSeeds) {
            cb.getItems().addAll(values);
            cb.getSelectionModel().selectFirst();
            
            cb.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
                @Override
                public ListCell<Integer> call(ListView<Integer> p) {
                    return new WeaponsCellFactory();
                }
            });
            
            cb.setButtonCell(new WeaponsButtonCell());
        }
        
        IntegerBinding seed = new IntegerBinding() {
            {
                super.bind(cbSeed1.valueProperty(), cbSeed2.valueProperty(), cbSeed3.valueProperty(),
                        cbSeed4.valueProperty(), cbSeed5.valueProperty(), cbSeed6.valueProperty());
            }
            
            @Override
            protected int computeValue() {
                int[] values = new int[cbSeeds.size()];
                
                for(int i = 0; i < cbSeeds.size(); i++) {
                    values[i] = cbSeeds.get(i).valueProperty().getValue();
                }
                
                return (values[0] << 25) | (values[1] << 20) | (values[2] << 15) | (values[3] << 10) | (values[4] << 5) | values[5];
            }
        };
        
        MainController.getInstance().getRandomizeSummary().seedProperty().bind(seed);
    }

    @FXML
    private void generateRandomSeed() {
        for(ComboBox<Integer> cb : cbSeeds) {
            cb.getSelectionModel().select((int) (Math.random() * SEED_MAX_VALUE));
        }
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
        long seed = (cbSeed1.getValue() << 25) + (cbSeed2.getValue() << 20) + (cbSeed3.getValue() << 15) + (cbSeed4.getValue() << 10) + (cbSeed5.getValue() << 5) + cbSeed6.getValue();
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
    
    private class WeaponsCellFactory extends ListCell<Integer> {
        @Override
        protected void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            
            if (item == null || empty) {
                setGraphic(null);
            } else {
                Image icon;
                String iconPath = "";
                
                try {
                    WeaponSeed wpnSeed = WeaponSeed.getBySeed(getIndex());
                    iconPath = "img/" + wpnSeed.getImageName();
                    icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                    setText(wpnSeed.getName());
                } catch(NullPointerException ex) {
                    // in case the above image doesn't exist, use a default one
                    System.out.println("Not found: " + iconPath);
                    iconPath = "img/hexrobot-logo.png";
                    icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                }
                
                ImageView iconImageView = new ImageView(icon);
                iconImageView.setFitHeight(32);
                iconImageView.setPreserveRatio(true);
                setGraphic(iconImageView);
            }
        }
    }
    
    private class WeaponsButtonCell extends ListCell<Integer> {
        @Override
        protected void updateItem(Integer item, boolean btl){
            super.updateItem(item, btl);
            if(item != null) {
                WeaponSeed wpnSeed = WeaponSeed.getBySeed(item);
                Image icon;
                
                try {
                    String iconPath = "img/" + wpnSeed.getImageName();
                    icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                } catch(NullPointerException ex) {
                    // in case the above image doesn't exist, use a default one
                    String iconPath = "img/hexrobot-logo.png";
                    icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                }
                
                ImageView imgView = new ImageView(icon);
                imgView.setFitHeight(32);
                imgView.setFitWidth(32);
                setGraphic(imgView);
            }
        }
    }
}
