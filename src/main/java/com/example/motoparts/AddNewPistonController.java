package com.example.motoparts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewPistonController implements Initializable {

    @FXML
    private TextField codeTF;

    @FXML
    private TextField diameterTF;

    @FXML
    private TextField totalHeightTF;

    @FXML
    private TextField compTF;

    @FXML
    private TextField pinDiameterTF;

    @FXML
    private TextField strokeTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField brandTF;

    @FXML
    private Button addPistonBttn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
