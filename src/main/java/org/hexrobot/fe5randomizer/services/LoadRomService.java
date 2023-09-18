package org.hexrobot.fe5randomizer.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hexrobot.fe5randomizer.Rom;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.hexrobot.fe5randomizer.util.InvalidRomDataException;

public class LoadRomService extends Service<Rom> {
    File file;

    public LoadRomService(File file) {
        this.file = file;
    }

    @Override
    protected Task<Rom> createTask() {

        return new Task<Rom>() {
            @Override
            protected Rom call() throws IOException, InvalidRomDataException {

                updateMessage("Loading file...");
                InputStream inputStream = new FileInputStream(file);

                Rom rom = new Rom(inputStream.readAllBytes());
                inputStream.close();

                if(rom.isFireEmblem5()) {
                    updateMessage("Reading rom...");
                    rom.initialize();
                    updateProgress(0.5, 1.0);
                }

                updateMessage("Finished loading.");

                return rom;
            }
        };
    }
}
