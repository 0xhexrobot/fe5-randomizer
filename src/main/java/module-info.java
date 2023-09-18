module org.hexrobot.fe5randomizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires freemarker;

    opens org.hexrobot.fe5randomizer;
    opens org.hexrobot.fe5randomizer.controllers;

    exports org.hexrobot.fe5randomizer;
    exports org.hexrobot.fe5randomizer.controllers;
    exports org.hexrobot.fe5randomizer.chapters to freemarker;
    exports org.hexrobot.fe5randomizer.characters to freemarker;
    exports org.hexrobot.fe5randomizer.items to freemarker;
    exports org.hexrobot.fe5randomizer.util to freemarker;
}
