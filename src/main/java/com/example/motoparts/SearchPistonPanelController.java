package com.example.motoparts;

import data.classes.Piston;
import data.classes.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SearchPistonPanelController implements Initializable {
    @FXML
    private ChoiceBox<String > strokeCB;

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
    private Button searchBtn;

    private final String[] strokes = {"2T" ,"4T" , "All Strokes"};

    @FXML
    void searchBtnClicked(ActionEvent actionEvent){
        String inCode = codeTF.getText();
        String inTotalHeight = totalHeightTF.getText();
        String inCompression = compressionHeightTF.getText();
        String inDiameter = diameterTF.getText();
        String inPinDiameter = pinDiameterTF.getText();
        String inModel = modelTF.getText();
        String inBrand = brandTF.getText();
        String inStroke = strokeCB.getValue();
        String inOversize = oversizeTF.getText();
        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        ResultSet rs;
        ObservableList<Piston> pistons =  FXCollections.observableArrayList();

        try {

            QueryGenerator generator = new QueryGenerator();
            String query = generator.generateSelectQuery(inCode , inTotalHeight ,inCompression , inDiameter , inPinDiameter , inModel , inBrand , inStroke ,inOversize);

            rs = controller.searchPistons(query);

            while(rs.next()){
                String pistonCode = rs.getString("pistonCode") ;
                Double diameter = rs.getDouble("diameter");
                Double totalHeight = rs.getDouble("totalHeight");
                Double compressionHeight = rs.getDouble("compressionHeight");
                Double pinDiameter = rs.getDouble("pinDiameter");
                String stroke = rs.getString("stroke");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String oversize = rs.getString("oversize");

                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model , oversize));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PistonPanelController panel = Singleton.getInstance().getData();
        panel.displaySearchResults(pistons);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        strokeCB.getItems().addAll(strokes);
    }
}
