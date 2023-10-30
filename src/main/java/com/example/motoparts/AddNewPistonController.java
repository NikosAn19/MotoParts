package com.example.motoparts;

import data.classes.Piston;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddNewPistonController implements Initializable {
    final String HAS_CHARACTERS = "HAS_CHARACTERS";
    final String HAS_NUMBERS = "HAS_NUMBERS";
    final String IS_EMPTY = "IS_EMPTY";
    final String IS_VALID = "IS_VALID";

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

    final String WARNING_TEXT_FIELD_STYLE = "-fx-border-color: red ; -fx-border-width: 1px ;";
    final String ACCEPTED_TEXT_FIELD_STYLE = "-fx-border-color: green ; -fx-border-width: 1px ;";

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


        if(validation(inCode , inDiameter , inHeight, inCompression, inPinDiameter, inStroke, inBrand, inModel, inOversize)){
            DatabaseController controller = new DatabaseController();
            controller.initDatabase();
            controller.insertPiston(inCode, inDiameter, inHeight, inCompression, inPinDiameter,
                    inStroke, inBrand, inModel , inOversize);
            System.out.println("Input is valid");
        }
        else{
            System.out.println("Input not valid");
        }


    }
    private boolean validation(String pistonCode, String diameter, String totalHeight, String compressionHeight,
                           String pinDiameter, String stroke, String brand, String model, String oversize){


        InputValidator inputValidator = new InputValidator();

        inputValidator.validateEmptiness(pistonCode);
        String codeStatus = inputValidator.getInputStatus();

        inputValidator.validateNumeric(totalHeight);
        String totalHeightStatus =inputValidator.getInputStatus();

        inputValidator.validateNumeric(compressionHeight);
        String compressionHeightStatus = inputValidator.getInputStatus();

        inputValidator.validateNumeric(diameter);
        String diameterStatus = inputValidator.getInputStatus();

        inputValidator.validateNumeric(pinDiameter);
        String pinDiameterStatus = inputValidator.getInputStatus();

        inputValidator.validateEmptiness(model);
        String modelStatus = inputValidator.getInputStatus();

        inputValidator.validateEmptiness(brand);
        String brandStatus = inputValidator.getInputStatus();

        inputValidator.validateEmptiness(oversize);
        String oversizeStatus = inputValidator.getInputStatus();

        boolean codeValidated = false;
        boolean totalHeightValidated = false;
        boolean compressionValidated = false;
        boolean diameterValidated = false;
        boolean pinDiameterValidated = false;
        boolean modelValidated = false;
        boolean brandValidated = false;
        boolean oversizeValidated = false;
        boolean strokeValidated = false;

        if(codeStatus.equals(IS_EMPTY)){
            codeTF.setStyle(WARNING_TEXT_FIELD_STYLE);
            System.out.println("Code TextField is empty");
        }
        else if(codeStatus.equals(IS_VALID)){
            codeValidated = true;
            codeTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(totalHeightStatus.equals(HAS_CHARACTERS)) {
            totalHeightTF.setStyle(WARNING_TEXT_FIELD_STYLE);
//            System.out.println(codeStatus);
        }
        else if(totalHeightStatus.equals(IS_EMPTY)){
            totalHeightTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }
        else if(totalHeightStatus.equals(IS_VALID)){
            totalHeightValidated = true;
            totalHeightTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);

        }

        if(compressionHeightStatus.equals(HAS_CHARACTERS)){
            compressionHeightTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        } else if(compressionHeightStatus.equals(IS_EMPTY)) {
            compressionHeightTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        } else if(compressionHeightStatus.equals(IS_VALID)){
            compressionValidated = true;
            compressionHeightTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(diameterStatus.equals(HAS_CHARACTERS)){
            diameterTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(diameterStatus.equals(IS_EMPTY)){
            diameterTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(diameterStatus.equals(IS_VALID)){
            diameterValidated = true;
            diameterTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(pinDiameterStatus.equals(HAS_CHARACTERS)){
            pinDiameterTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(pinDiameterStatus.equals(IS_EMPTY)){
            pinDiameterTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(pinDiameterStatus.equals(IS_VALID)){
            pinDiameterValidated = true;
            pinDiameterTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(modelStatus.equals(IS_EMPTY)){
            modelTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(modelStatus.equals(IS_VALID)){
            modelValidated = true;
            modelTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(brandStatus.equals(IS_EMPTY)){
            brandTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(brandStatus.equals(IS_VALID)){
            brandValidated = true;
            brandTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(oversizeStatus.equals(IS_EMPTY)){
            oversizeTF.setStyle(WARNING_TEXT_FIELD_STYLE);
        }else if(oversizeStatus.equals(IS_VALID)){
            oversizeValidated = true;
            oversizeTF.setStyle(ACCEPTED_TEXT_FIELD_STYLE);
        }

        if(stroke != null){
            strokeValidated = true;
            strokeCB.setStyle(ACCEPTED_TEXT_FIELD_STYLE);

        }
        else{
            strokeCB.setStyle(WARNING_TEXT_FIELD_STYLE);
        }

        ArrayList<Boolean> validatedInput = new ArrayList<>();
        validatedInput.add(codeValidated);
        validatedInput.add(totalHeightValidated);
        validatedInput.add(compressionValidated);
        validatedInput.add(diameterValidated);
        validatedInput.add(pinDiameterValidated);
        validatedInput.add(modelValidated);
        validatedInput.add(brandValidated);
        validatedInput.add(oversizeValidated);
        validatedInput.add(strokeValidated);

        boolean isValid = false;

        if(inputValidator.isInputValid(validatedInput)){
            isValid = true;
        }
        return isValid;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        strokeCB.getItems().addAll(strokes);

    }

}


