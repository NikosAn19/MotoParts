package com.example.motoparts;

import data.classes.Piston;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PistonTableController implements Initializable {
    private ArrayList<String> pistonData;
    private LinkedHashMap<String , String> pistonMap;

    private LinkedHashMap<Integer , String> parameters;

    private String query = "SELECT *" +"\n" +
                           "FROM PISTONS"+ "\n" +
                           "WHERE" +"\n" ;
    @FXML
    private TableView<Piston> pistonTable;

    @FXML
    private TableColumn<Piston, String> pistonCodeCol;

    @FXML
    private TableColumn<Piston, Double> pistonDiameterCol;

    @FXML
    private TableColumn<Piston, Double> pistonTotalHeightCol;

    @FXML
    private TableColumn<Piston, Double> pistonCompressionHeightcol;

    @FXML
    private TableColumn<Piston, Double> pinDiameterCol;

    @FXML
    private TableColumn<Piston, String> pistonStrokeCol;

    @FXML
    private TableColumn<Piston, String> pistonBrandCol;

    @FXML
    private TableColumn<Piston, String> pistonModelCol;

    @FXML
    private TextField compressionHeightTF;

    @FXML
    private TextField diameterTF;

    @FXML
    private TextField pinDiameterTF;

    @FXML
    private TextField modelTF;

    @FXML
    private TextField brandTF;

    @FXML
    private ChoiceBox<String> strokeCB;

    @FXML
    private Button searchBtn;

    private final String[] strokes = {"2T" ,"4T"};

    @FXML
    void searchPistons(MouseEvent event) {
        String inCompression = compressionHeightTF.getText();
        String inDiameter = diameterTF.getText();
        String inPinDiameter = pinDiameterTF.getText();
        String inModel = modelTF.getText();
        String inBrand = brandTF.getText();
        String inStroke = strokeCB.getValue();
        DatabaseController controller = new DatabaseController();
        controller.initDatabase();
        ResultSet rs;
        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
        String queryPart = "";

        try {

            pistonMap = new LinkedHashMap<>();
            parameters = new LinkedHashMap<>();
            if(inCompression != "" && inCompression != null){
                pistonMap.put("compression" , inCompression);
            }
            if(inDiameter != "" && inDiameter != null){
                pistonMap.put("diameter" , inDiameter);
            }
            if(inPinDiameter != "" && inPinDiameter != null){
                pistonMap.put("pinDiameter" , inPinDiameter);
            }
            if(inModel != "" && inModel != null){
                pistonMap.put("model" , inModel);
            }
            if(inBrand != "" && inBrand != null){
                pistonMap.put("brand" , inBrand);
            }
            if(inStroke != "" && inStroke != null){
                pistonMap.put("stroke" , inStroke);
            }

            int elementCounter = 1;
            int pistonMapSize = pistonMap.size();
            for (Map.Entry<String, String> set :
                    pistonMap.entrySet()) {
                    if(elementCounter == pistonMapSize){
                        queryPart = queryPart +"PISTONS."+set.getKey() +" = " +set.getValue()  +";";
                    }
                    else{
                        queryPart = queryPart +"PISTONS."+set.getKey() +" = " +set.getValue()  +" AND " ;
                    }

                parameters.put(elementCounter , set.getValue());
                elementCounter++;
            }
            query = query + queryPart;
            System.out.println(query);
            query = "SELECT * "  +
                    "FROM PISTONS " +
                    "WHERE "  ;

            String query2 = "SELECT * FROM PISTONS WHERE PISTONS.brand = Yamaha ;";

            rs = controller.searchPistons(query , parameters);
            while(rs.next()){
                String pistonCode = rs.getString("pistonCode") ;
                Double diameter = rs.getDouble("diameter");
                Double totalHeight = rs.getDouble("height");
                Double compressionHeight = rs.getDouble("compressionHeight");
                Double pinDiameter = rs.getDouble("pinDiameter");
                String stroke = rs.getString("stroke");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
//                System.out.println(pistonCode +" " +diameter +" " +totalHeight + " " +compressionHeight + " " +pinDiameter + " " +stroke +" " +brand + " " +model);

                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
            }

//            if(inCompression == "" &&  inDiameter != "" && inPinDiameter != "" && inModel != "" && inBrand != "" && inStroke != null){
//                rs = controller.getPistonsWithoutComp(Double.parseDouble(inDiameter) ,
//                        Double.parseDouble(inPinDiameter) , inModel , inBrand , inStroke);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if( inCompression == "" &&  inDiameter == "" && inPinDiameter != "" && inModel != "" && inBrand != "" && inStroke != null){
//                rs = controller.getPistonsWithoutCompAndDiameter(Double.parseDouble(inPinDiameter) , inModel , inBrand , inStroke);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter == "" && inPinDiameter == "" && inModel != "" && inBrand != "" && inStroke != null){
//                rs = controller.getPistonsWithoutCompDiameterAndPinDiameter(inModel , inBrand , inStroke);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter == "" && inPinDiameter == "" && inModel == "" && inBrand != "" && inStroke != null){
//                rs = controller.getPistonsWithoutCompDiameterAndPinDiameterAndModel(inBrand , inStroke);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter == "" && inPinDiameter == "" && inModel == "" && inBrand == "" && inStroke != null){
//                rs = controller.getOnlyWithStroke(inStroke);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter != "" && inPinDiameter == "" && inModel == "" && inBrand == "" && inStroke == null ){
//                rs = controller.getOnlyWithDiameter(Double.parseDouble(inDiameter));
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter == "" && inPinDiameter == "" && inModel == "" && inBrand != "" && inStroke == null){
//                rs = controller.getOnlyWithBrand(inBrand);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression != "" &&  inDiameter == "" && inPinDiameter == "" && inModel == "" && inBrand == "" && inStroke == null){
//                rs = controller.getOnlyWithCompression(inCompression);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }
//            else if(inCompression == "" &&  inDiameter == "" && inPinDiameter == "" && inModel != "" && inBrand == "" && inStroke == null){
//                rs = controller.getOnlyWithModel(inModel);
//                while(rs.next()){
//                    String pistonCode = rs.getString("pistonCode") ;
//                    Double diameter = rs.getDouble("diameter");
//                    Double totalHeight = rs.getDouble("height");
//                    Double compressionHeight = rs.getDouble("compressionHeight");
//                    Double pinDiameter = rs.getDouble("pinDiameter");
//                    String stroke = rs.getString("stroke");
//                    String brand = rs.getString("brand");
//                    String model = rs.getString("model");
//
//                    pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
//                }
//            }

//            rs = controller.getPistonsByDetails(Double.valueOf(inCompression) , Double.parseDouble(inDiameter) ,
//                                                Double.parseDouble(inPinDiameter) , inModel , inBrand , inStroke);

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        pistonTable.setItems(pistons);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {

       DatabaseController controller = new DatabaseController();
       controller.initDatabase();
       ResultSet rs;
        ObservableList<Piston> pistons =  FXCollections.observableArrayList();
        try {
            rs = controller.getAllPistons();
            while(rs.next()){
                String pistonCode = rs.getString("pistonCode") ;
                Double diameter = rs.getDouble("diameter");
                Double totalHeight = rs.getDouble("height");
                Double compressionHeight = rs.getDouble("compressionHeight");
                Double pinDiameter = rs.getDouble("pinDiameter");
                String stroke = rs.getString("stroke");
                String brand = rs.getString("brand");
                String model = rs.getString("model");

                pistons.add(new Piston(pistonCode , diameter , totalHeight , compressionHeight, pinDiameter , stroke ,  brand , model));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pistonCodeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("pistonCode"));
        pistonDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("diameter"));
        pistonTotalHeightCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("totalHeight"));
        pistonCompressionHeightcol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("compressionHeight"));
        pinDiameterCol.setCellValueFactory(new PropertyValueFactory<Piston , Double>("pinDiameter"));
        pistonStrokeCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("stroke"));
        pistonBrandCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("brand"));
        pistonModelCol.setCellValueFactory(new PropertyValueFactory<Piston , String>("model"));


        pistonTable.setItems(pistons);

        strokeCB.getItems().addAll(strokes);



    }
}