module com.example.motoparts {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.java;
//    requires com.gluonhq.charm.glisten;

    opens com.example.motoparts to javafx.fxml;
    opens data.classes to javafx.fxml;
    exports com.example.motoparts;
    exports data.classes;
}