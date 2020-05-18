package org.hexrobot.fe5randomizer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.characters.GameCharacter;

import freemarker.core.TemplateNumberFormatFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RandomizeRomService extends Service<Void> {
    private Rom rom;
    private RandomizeSummary randomizeSummary;
    private Configuration cfg;
    
    public RandomizeRomService(Rom rom, RandomizeSummary randomizeSummary) {
        this.rom = rom;
        this.randomizeSummary = randomizeSummary;
        
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassForTemplateLoading(getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");

        Map<String, TemplateNumberFormatFactory> customNumberFormats = new HashMap<String, TemplateNumberFormatFactory>();
        customNumberFormats.put("hex", HexTemplateNumberFormatFactory.INSTANCE);
        cfg.setCustomNumberFormats(customNumberFormats);
    }
    
    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                Map<String, Object> input = new HashMap<String, Object>();
                
                if(randomizeSummary.getRandomizeBases()) {
                    updateMessage("Randomize unit bases...");
                    
                    if(randomizeSummary.getBasesRandomizationType().equals("variance")) {
                        rom.randomizeUnitsBasesVariance(randomizeSummary.getBasesVariance());
                    } else if(randomizeSummary.getBasesRandomizationType().equals("redistribute")) {
                        rom.randomizeUnitsBasesRedistribute(randomizeSummary.getBasesRedistributeVar());
                    }
                }

                updateMessage("Writing log...");
                
                input.put("romHeadered", rom.isHeadered());
                input.put("romChecksum", Long.toHexString(rom.getCrc32Checksum()));
                input.put("randomizeSummary", randomizeSummary);
                input.put("units", GameCharacter.values());
                // input.put("items", Item.values());

                try {
                    Writer fileWriter = new FileWriter(new File("output.md"));
                    Template template = cfg.getTemplate("md.ftl");
                    
                    template.process(input, fileWriter);
                    fileWriter.close();
                } catch(IOException e) {
                    e.printStackTrace();
                } catch(TemplateException e) {
                    e.printStackTrace();
                } finally {
                    updateMessage("Log created!");
                }
                
                return null;
            }
        };
    }
}
