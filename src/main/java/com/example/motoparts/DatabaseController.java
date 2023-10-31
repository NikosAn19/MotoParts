package com.example.motoparts;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DatabaseController {
    Connection conn ;

    public DatabaseController(){

    }
    public void initDatabase()  {
        //Initialize database connection.
        DatabaseConnection db= new DatabaseConnection();
        this.conn = db.getDBConnection();
        System.out.println("Database connection established.");
        try{
            conn.setAutoCommit(true);
        }
        catch (Exception e){

        }
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

    public void insertPiston(String inCode , String inDiameter , String inHeight , String inCompression ,
                             String inPinDiameter , String inStroke , String inBrand , String inModel , String inOversize)  {

        try{

            String query = "INSERT INTO Pistons(pistonCode , diameter , totalHeight , compressionHeight , pinDiameter , stroke , brand , model , oversize) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?)" ;
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

            System.out.println(statement.execute());
            statement.close();


        }catch (SQLException e){

            System.out.println("Duplicate entry");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alertDialog.fxml"));
                Parent root = (Parent)fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene((root)));
                stage.show();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("The piston with code : " +inCode +" and diameter : " +inDiameter +" has been inserted");

    }

    public void deletePiston(String inCode ){

        try{

            String query = "DELETE FROM PISTONS WHERE pistonCode =?" ;
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1 , inCode);
            statement.executeUpdate();
            statement.close();
            System.out.println("Piston deleted");

            return;
        }catch (SQLException e){


        }
        System.out.println("The piston with code : " +inCode  + " has been deleted");

    }
    public void updatePiston(String inCode, String inDiameter, String inHeight, String inCompression,
                             String inPinDiameter, String inStroke, String inBrand, String inModel,
                             String inOversize, String oldCode){

        String query = "UPDATE PISTONS SET pistonCode=?, diameter=?, totalHeight=?, compressionHeight=?, pinDiameter=?," +
                       " stroke=?, brand=?, model=?, oversize=? WHERE pistonCode=?";

       try{
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
           statement.setString(10 , oldCode);

           System.out.println(statement.execute());
           statement.close();
           System.out.println("Piston updated successfully");
       }catch(Exception e){
           System.out.println("ekanes malakia");
       }


    }



}
