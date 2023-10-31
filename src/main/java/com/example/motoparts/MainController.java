package com.example.motoparts;

import data.classes.PistonPanelStageSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;


public class MainController extends Application {

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("PistonPanelNew.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Moto Parts");
        stage.setScene(scene);
        PistonPanelStageSingleton.setData(stage);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}