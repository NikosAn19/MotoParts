package com.example.motoparts;

import data.classes.Piston;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.sql.*;

public class DatabaseController {
    Connection conn ;

    public DatabaseController(){

    }
    public void initDatabase(){
        //Initialize database connection.
        DatabaseConnection db= new DatabaseConnection();
        this.conn = db.getDBConnection();
        System.out.println("Database connection established.");
    }

    public ResultSet getAllPistons() throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_all_Pistons()");
        System.out.println("Callable statement completed");
        myStm.execute();
        System.out.println("Stored procedure executed.");
        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }

    public ResultSet searchPistons(String query) throws SQLException{
        ResultSet rs;
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(query);
        System.out.println("Statement executed");

        return rs;
    }

    public String insertPiston(String inCode , String inDiameter , String inHeight , String inCompression ,
                                String inPinDiameter , String inStroke , String inBrand , String inModel , String inOversize)  {

        try{

            String query = "INSERT INTO PISTONS(pistonCode , diameter , height , compressionHeight , pinDiameter , stroke , brand , model , oversize) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?)" ;
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1 , inCode);
            statement.setDouble(2 , Double.parseDouble(inDiameter));
            statement.setDouble(3 , Double.parseDouble(inHeight));
            statement.setDouble(4 , Double.parseDouble(inCompression));
            statement.setDouble(5 , Double.parseDouble(inPinDiameter));
            statement.setString(6 , inStroke);
            statement.setString(7 , inBrand);
            statement.setString(8 , inModel);
            statement.setString(9 , inOversize);

            statement.executeUpdate();
            statement.close();

            return "The piston with code : " +inCode +" and diameter : " +inDiameter +" has been inserted";
        }catch (SQLException e){

//            System.out.println("Duplicate entry");
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alertDialog.fxml"));
//                Parent root = (Parent)fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setScene(new Scene((root)));
//                stage.show();
//
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        }
        return "The piston with code : " +inCode +" and diameter : " +inDiameter +" has been inserted";
    }

    public String deletePiston(String inCode ){

        try{

            String query = "DELETE FROM PISTONS WHERE pistonCode =?" ;
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1 , inCode);
            statement.executeUpdate();
            statement.close();
            System.out.println("Piston deleted");

            return "The piston with code : " +inCode +" has been deleted";
        }catch (SQLException e){


        }
        return "The piston with code : " +inCode  + " has been deleted";

    }



}
