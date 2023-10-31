package com.example.motoparts;

import data.classes.Piston;
import data.classes.PistonDataSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPistonPanelController implements Initializable {
    @FXML
    private TextField brandTF;

    @FXML
    private TextField codeTF;

    @FXML
    private TextField compressionHeightTF;

    @FXML
    private TextField diameterTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField oversizeTF;

    @FXML
    private TextField pinDiameterTF;

    @FXML
    private ChoiceBox<String> strokeCB;

    @FXML
    private TextField totalHeightTF;

    @FXML
    private Button updateBtn;

    private final String[] strokes = {"2T", "4T"};

    private String oldCode = "";

    @FXML
    void updateEditBtnClicked(ActionEvent event) {
        try{
            DatabaseController controller = new DatabaseController();
            controller.initDatabase();

            controller.updatePiston(codeTF.getText(), diameterTF.getText(), totalHeightTF.getText(),
                    compressionHeightTF.getText(),pinDiameterTF.getText(), strokeCB.getValue(),
                    brandTF.getText(), modelTF.getText(), oversizeTF.getText() , oldCode);

            Stage stage = (Stage)updateBtn.getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Pali malakia ekanes");
        }



    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         Piston piston = PistonDataSingleton.getInstance().getData();
         codeTF.setText(piston.getPistonCode());
         totalHeightTF.setText(String.valueOf(piston.getTotalHeight()));
         compressionHeightTF.setText(String.valueOf(piston.getCompressionHeight()));
         diameterTF.setText(String.valueOf(piston.getDiameter()));
         pinDiameterTF.setText(String.valueOf(piston.getPinDiameter()));
         brandTF.setText(piston.getBrand());
         modelTF.setText(piston.getModel());
         oversizeTF.setText(piston.getOversize());
         strokeCB.setValue(piston.getStroke());

        strokeCB.getItems().addAll(strokes);
        oldCode = piston.getPistonCode();

    }
}
