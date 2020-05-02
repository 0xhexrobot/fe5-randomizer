package org.hexrobot.fe5randomizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoadRomService extends Service<Rom> {
    File file;

    public LoadRomService(File file) {
        this.file = file;
    }

    @Override
    protected Task<Rom> createTask() {

        return new Task<Rom>() {
            @Override
            protected Rom call() throws Exception {
                Rom rom = null;

                try {
                    updateMessage("Loading file...");
                    InputStream inputStream = new FileInputStream(file);

                    rom = new Rom(inputStream.readAllBytes());
                    inputStream.close();
                    
                    updateProgress(0.1, 1.0);

                    if(rom.isFireEmblem5()) {
                        updateProgress(0.4, 1.0);
                        updateMessage("Reading Items...");
                        rom.initializeItems();
                        updateProgress(0.7, 1.0);
                        updateMessage("Reading characters...");
                        rom.initializeCharacters();
                        updateProgress(1.0, 1.0);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }

                return rom;
            }
        };
    }
}
