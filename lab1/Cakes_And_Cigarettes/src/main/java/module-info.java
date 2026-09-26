module org.example.cakes_and_cigarettes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.cakes_and_cigarettes to javafx.fxml;
    opens org.example.cakes_and_cigarettes.view to javafx.fxml;
    opens org.example.cakes_and_cigarettes.controller to javafx.fxml;

    exports org.example.cakes_and_cigarettes;
    exports org.example.cakes_and_cigarettes.model;
    exports org.example.cakes_and_cigarettes.view;
    exports org.example.cakes_and_cigarettes.controller;
}