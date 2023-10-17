package com.example.motoparts;

import data.classes.Piston;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javafx.stage.Stage;

public class PistonTableController {
//    private ArrayList<String> pistonData;
//    private LinkedHashMap<String , String> pistonMap;
//    private LinkedHashMap<Integer , String> parameters;
//
//    @FXML
//    private TableView<Piston> pistonTable;
//
//    @FXML
//    private TableColumn<Piston, String> pistonCodeCol;
//
//    @FXML
//    private TableColumn<Piston, Double> pistonDiameterCol;
//
//    @FXML
//    private TableColumn<Piston, Double> pistonTotalHeightCol;
//
//    @FXML
//    private TableColumn<Piston, Double> pistonCompressionHeightcol;
//
//    @FXML
//    private TableColumn<Piston, Double> pinDiameterCol;
//
//    @FXML
//    private TableColumn<Piston, String> pistonStrokeCol;
//
//    @FXML
//    private TableColumn<Piston, String> pistonBrandCol;
//
//    @FXML
//    private TableColumn<Piston, String> pistonModelCol;
//
//    @FXML
//    private TextField compressionHeightTF;
//
//    @FXML
//    private TextField diameterTF;
//
//    @FXML
//    private TextField pinDiameterTF;
//
//    @FXML
//    private TextField modelTF;
//
//    @FXML
//    private TextField brandTF;
//
//    @FXML
//    private ChoiceBox<String> strokeCB;
//
//    @FXML
//    private Button searchBtn;
//
//    @FXML
//    private Button deletePistonBttn;
//
//    private final String[] strokes = {"2T" ,"4T"};
//
//    @FXML
//    private Button refreshBtn;
//
//
//    @FXML
//    void refresh(ActionEvent event) {
//        DatabaseController controller = new DatabaseController();
//        controller.initDatabase();
//        ResultSet rs;
//        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
//        try {
//            rs = controller.getAllPistons();
//            while(rs.next()){
//                String pistonCode = rs.getString("pistonCode") ;
//                Double diameter = rs.getDouble("diameter");
//                Double totalHeight = rs.getDouble("height");
//                Double compressionHeight = rs.getDouble("compressionHeight");
//                Double pinDiameter = rs.getDouble("pinDiameter");
//                String stroke = rs.getString("stroke");
//                String brand = rs.getString("brand");
//                String model = rs.getString("model");
//
//                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
//        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
//        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
//        pistonCompressionHeightcol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
//        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
//        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
//        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
//        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));
//
//        pistonTable.setItems(pistons);
//
//        strokeCB.getItems().addAll(strokes);
//        deletePistonBttn.setDisable(false);
//    }
//
//    @FXML
//    void deletePistonPressed(ActionEvent event){
//
//        ObservableList<Piston> list = pistonTable.getSelectionModel().getSelectedItems();
//        System.out.println(list.get(0).getPistonCode()+" " +list.get(0).getModel() +" " +list.get(0).getBrand() +" " +list.get(0).getDiameter());
//        DatabaseController controller = new DatabaseController();
//        controller.initDatabase();
//        controller.deletePiston(list.get(0).getPistonCode());
//
//        int id = pistonTable.getSelectionModel().getSelectedIndex();
//        pistonTable.getItems().remove(id);
//
//
//    }
//
//    @FXML
//    void openNewPistonWindow(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addNewPiston.fxml"));
//        Parent root = (Parent)fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene((root)));
//        stage.show();
//
//    }
//
//    @FXML
//    void searchPistons(MouseEvent event) {
//        String inCompression = compressionHeightTF.getText();
//        String inDiameter = diameterTF.getText();
//        String inPinDiameter = pinDiameterTF.getText();
//        String inModel = modelTF.getText();
//        String inBrand = brandTF.getText();
//        String inStroke = strokeCB.getValue();
//        DatabaseController controller = new DatabaseController();
//        controller.initDatabase();
//        ResultSet rs;
//        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
//
//        try {
//
//            QueryGenerator generator = new QueryGenerator();
////            String query = generator.generateSelectQuery(inCompression , inDiameter , inPinDiameter , inModel , inBrand , inStroke);
//
////            rs = controller.searchPistons(query);
//
//            while(rs.next()){
//                String pistonCode = rs.getString("pistonCode") ;
//                Double diameter = rs.getDouble("diameter");
//                Double totalHeight = rs.getDouble("height");
//                Double compressionHeight = rs.getDouble("compressionHeight");
//                Double pinDiameter = rs.getDouble("pinDiameter");
//                String stroke = rs.getString("stroke");
//                String brand = rs.getString("brand");
//                String model = rs.getString("model");
//
//                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//            }
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        pistonTable.setItems(pistons);
//
//
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle)  {
//
//       DatabaseController controller = new DatabaseController();
//       controller.initDatabase();
//       ResultSet rs;
//        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
//        try {
//            rs = controller.getAllPistons();
//            while(rs.next()){
//                String pistonCode = rs.getString("pistonCode") ;
//                Double diameter = rs.getDouble("diameter");
//                Double totalHeight = rs.getDouble("height");
//                Double compressionHeight = rs.getDouble("compressionHeight");
//                Double pinDiameter = rs.getDouble("pinDiameter");
//                String stroke = rs.getString("stroke");
//                String brand = rs.getString("brand");
//                String model = rs.getString("model");
//
//                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
//        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
//        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
//        pistonCompressionHeightcol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
//        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
//        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
//        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
//        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));
//
//        pistonTable.setItems(pistons);
//
//        strokeCB.getItems().addAll(strokes);
//        deletePistonBttn.setDisable(false);
//
////        pistonTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
////            if (newSelection != null) {
////
////                deletePistonBttn.setDisable(false);
////               ObservableList<Piston> list = pistonTable.getSelectionModel().getSelectedItems();
////               System.out.println(list.get(0).getPistonCode()+" " +list.get(0).getModel() +" " +list.get(0).getBrand() +" " +list.get(0).getDiameter());
////
////                controller.initDatabase();
////                controller.deletePiston(list.get(0).getPistonCode());
////
////
////            }
////
////        });
//
//    }
//}
}