package org.hexrobot.fe5randomizer.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hexrobot.fe5randomizer.Rom;

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

                    if(rom.isFireEmblem5()) {
                        updateMessage("Reading rom...");
                        rom.initialize();
                        updateProgress(0.5, 1.0);
                    }
                    
                    updateMessage("Finished loading.");
                } catch(IOException e) {
                    e.printStackTrace();
                }

                return rom;
            }
        };
    }
}
