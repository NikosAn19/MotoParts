package com.example.motoparts;

import data.classes.Piston;
import data.classes.PistonDataSingleton;
import data.classes.PistonPanelStageSingleton;
import data.classes.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class PistonPanelController implements Initializable {

    @FXML
    private TableView<Piston> pistonTable;
    @FXML
    private TableColumn<Piston, String> pistonCodeCol;

    @FXML
    private TableColumn<Piston, Double> pistonDiameterCol;

    @FXML
    private TableColumn<Piston, Double> pistonTotalHeightCol;

    @FXML
    private TableColumn<Piston, Double> pistonCompressionHeightCol;

    @FXML
    private TableColumn<Piston, Double> pinDiameterCol;

    @FXML
    private TableColumn<Piston, String> pistonStrokeCol;

    @FXML
    private TableColumn<Piston, String> pistonBrandCol;

    @FXML
    private TableColumn<Piston, String> pistonModelCol;

    @FXML
    private TableColumn<Piston, String> pistonOversizeCol;

    @FXML
    private Button searchPistonsBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button refreshBtn;

    @FXML
    private AnchorPane topBar;

    private double x,y = 0;
    @FXML
    void editSelectedItemClicked(ActionEvent event) throws IOException {
        try{
            ObservableList<Piston> list = pistonTable.getSelectionModel().getSelectedItems();
            String code = list.get(0).getPistonCode();
            String brand = list.get(0).getBrand();
            String model = list.get(0).getModel();
            String diameter = String.valueOf(list.get(0).getDiameter());
            String totalHeight = String.valueOf(list.get(0).getTotalHeight());
            String pinDiameter = String.valueOf(list.get(0).getPinDiameter());
            String compressionHeight = String.valueOf(list.get(0).getCompressionHeight());
            String stroke = list.get(0).getStroke();
            String oversize = list.get(0).getOversize();

            Piston piston = list.get(0);
            PistonDataSingleton.setData(piston);

            openEditWindow();
        }catch (Exception e){
            System.out.println("Select an item to edit");
        }


    }
    @FXML
    private void openEditWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditPistonPanel.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene((root)));
        stage.show();

    }

    @FXML
    void openNewPistonWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addNewPistonPanel.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene((root)));
        stage.show();

    }

    @FXML
    void deletePistonPressed(ActionEvent event){

        ObservableList<Piston> list = pistonTable.getSelectionModel().getSelectedItems();
        System.out.println(list.get(0).getPistonCode()+" " +list.get(0).getModel() +" " +list.get(0).getBrand() +" "
                +list.get(0).getDiameter());
        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        controller.deletePiston(list.get(0).getPistonCode());

        int id = pistonTable.getSelectionModel().getSelectedIndex();
        pistonTable.getItems().remove(id);


    }
    @FXML
    void refresh(ActionEvent event) {
        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        ResultSet rs;
        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
        try {
            rs = controller.getAllPistons();
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

                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight,
                        pinDiameter , stroke ,  brand , model , oversize));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
        pistonCompressionHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));
        pistonOversizeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("oversize"));
        pistonTable.setItems(pistons);


    }
    @FXML
    void openSearchPistonWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchPistonPanel.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene((root)));
        stage.show();

    }

    @FXML
    public void displaySearchResults(ObservableList<Piston> pistons){

        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
        pistonCompressionHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));
        pistonOversizeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("oversize"));

        pistonTable.setItems(pistons);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        ResultSet rs;
        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
        try {
            rs = controller.getAllPistons();
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
        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
        pistonCompressionHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));
        pistonOversizeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("oversize"));

        pistonTable.setItems(pistons);

        Stage stage = PistonPanelStageSingleton.getInstance().getData();
//
//        topBar.setOnMousePressed(mouseEvent -> {
//            x = mouseEvent.getSceneX();
//            y = mouseEvent.getSceneY();
//        });
//        topBar.setOnMouseDragged(mouseEvent -> {
//            stage.setX(mouseEvent.getScreenX() -x);
//            stage.setY(mouseEvent.getScreenY() -y);
//        });

        Singleton.setData(this);
    }
}
