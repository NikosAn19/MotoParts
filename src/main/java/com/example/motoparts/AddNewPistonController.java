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

    @FXML
    private ChoiceBox<String> strokeCB;

    private final String[] strokes = {"2T", "4T"};

    String query = "INSERT INTO PISTON";

    @FXML
    void addNewPiston(ActionEvent actionEvent) throws SQLException {
        String inCode = codeTF.getText();
        String inHeight = totalHeightTF.getText();
        String inCompression = compTF.getText();
        String inDiameter = diameterTF.getText();
        String inPinDiameter = pinDiameterTF.getText();
        String inModel = modelTF.getText();
        String inBrand = brandTF.getText();
        String inStroke = strokeCB.getValue();


        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        controller.insertPiston(inCode, inDiameter, inHeight, inCompression, inPinDiameter, inStroke, inBrand, inModel);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        strokeCB.getItems().addAll(strokes);

    }

}


