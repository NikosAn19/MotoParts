package com.example.motoparts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class AlertDialogController implements Initializable {

    @FXML
    private Button closeBttn;

    @FXML
    private BorderPane borderPane;

    Stage stage;

    @FXML
    void closeWindow(ActionEvent actionEvent){
        stage = (Stage)borderPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
