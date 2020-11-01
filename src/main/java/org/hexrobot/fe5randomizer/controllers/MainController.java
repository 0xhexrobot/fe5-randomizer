package org.hexrobot.fe5randomizer.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Pane content;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuLoadRom;
    @FXML
    private MenuItem menuRandomize;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private Label lblStatus;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private LoadRomController loadRomController;
    
    public static final String VERSION = "v1.0.1+";
    public static final String CONFIG_FILENAME = "fe5-rand.config";
    private static MainController instance;
    private Stage stage;
    private SectionsController sectionsController;
    private Parent vBox;
    private RandomizationSummary randomizeSummary;
    private Rom rom;
    private SimpleBooleanProperty mainSections = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty disableContent = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty statusBarControlsVisible = new SimpleBooleanProperty(false);
    
    public MainController() {
        instance = this;
    }
    
    public static MainController getInstance() {
        return instance;
    }
    
    @FXML
    private void initialize()  throws IOException {
        randomizeSummary = new RandomizationSummary();
        loadRomController.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Sections.fxml"));
        vBox = loader.load();
        sectionsController = loader.getController();
        
        menuLoadRom.visibleProperty().bind(mainSections.not());
        menuRandomize.visibleProperty().bind(mainSections);        
        lblStatus.visibleProperty().bind(statusBarControlsVisible);
        progressBar.visibleProperty().bind(statusBarControlsVisible);
        content.disableProperty().bind(disableContent);
        menuBar.disableProperty().bind(disableContent);
    }
    
    @FXML
    private void loadRom() {
        loadRomController.openFileDialog();
    }
    
    @FXML
    private void randomize() {
        if(sectionsController.getSelectedTab().equals("randomize")) {
            sectionsController.getRandomizeController().randomize();
        } else {
            sectionsController.setRandomizeTab();
        }
    }
    
    @FXML
    private void close() {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void about() {
        Stage dialog = new Stage();
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("About.fxml"));
            dialog.setScene(new Scene(root));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        dialog.setTitle("About...");
        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }
    
    public void switchToSectionsController(Rom rom) {
        mainSections.set(true);
        sectionsController.setRom(rom, stage);
        content.getChildren().clear();
        content.getChildren().add(vBox);
        stage.sizeToScene();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
        
    public Label getStatusLabel() {
        return lblStatus;
    }
    
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    
    public RandomizationSummary getRandomizeSummary() {
        return randomizeSummary;
    }
        
    public Rom getRom() {
        return rom;
    }
    
    public void setRom(Rom rom) {
        this.rom = rom;
    }
    
    public SimpleBooleanProperty disableContentProperty() {
        return disableContent;
    }
    
    public SimpleBooleanProperty statusBarControlsVisibleProperty() {
        return statusBarControlsVisible;
    }
    
    public long getSeed() {
        return sectionsController.getSeed();
    }
    
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream is = null;
        Properties properties = null;
        try {
            is = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(is);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        return properties;
    }
}
