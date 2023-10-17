package com.example.motoparts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddNewPistonController implements Initializable {

    @FXML
    private ChoiceBox<String> strokeCB;

    @FXML
    private TextField codeTF;

    @FXML
    private TextField totalHeightTF;

    @FXML
    private TextField compressionHeightTF;

    @FXML
    private TextField diameterTF;

    @FXML
    private TextField pinDiameterTF;

    @FXML
    private TextField brandTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField oversizeTF;

    @FXML
    private Button addPistonBttn;


    private final String[] strokes = {"2T", "4T"};



    @FXML
    void addNewPiston(ActionEvent actionEvent) throws SQLException {
        String inCode = codeTF.getText();
        String inHeight = totalHeightTF.getText();
        String inCompression = compressionHeightTF.getText();
        String inDiameter = diameterTF.getText();
        String inPinDiameter = pinDiameterTF.getText();
        String inModel = modelTF.getText();
        String inBrand = brandTF.getText();
        String inStroke = strokeCB.getValue();
        String inOversize = oversizeTF.getText();



        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        controller.insertPiston(inCode, inDiameter, inHeight, inCompression, inPinDiameter, inStroke, inBrand, inModel , inOversize);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        strokeCB.getItems().addAll(strokes);

    }

}


