package com.example.motoparts;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public ResultSet searchPistons(String query , LinkedHashMap<Integer , String > parameters) throws SQLException{
        ResultSet rs;
        PreparedStatement statement = conn.prepareStatement(query);
        for (Map.Entry<Integer, String> set :
                parameters.entrySet()) {
            statement.setString(set.getKey() , set.getValue());
        }
        rs = statement.executeQuery();

        return rs;
    }


    public ResultSet getPistonsByDetails(Double compHeight , Double diameter , Double pinDiameter , String model , String brand , String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Piston_by_details(? , ? , ? , ? , ?  , ?)");
        myStm.setDouble(1, compHeight);
        myStm.setDouble(2, diameter);
        myStm.setDouble(3, pinDiameter);
        myStm.setString(4, model);
        myStm.setString(5, brand);
        myStm.setString(6, stroke);
        System.out.println("Callable statement completed");

        myStm.execute();
        System.out.println("Stored procedure executed.");

        //Get the Result set after execution. 
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }

    public ResultSet getPistonsWithoutComp(Double diameter , Double pinDiameter , String model , String brand , String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Without_Compression( ? , ? , ? , ? , ?)");
        myStm.setDouble(1, diameter);
        myStm.setDouble(2, pinDiameter);
        myStm.setString(3, model);
        myStm.setString(4, brand);
        myStm.setString(5, stroke);
        System.out.println("Callable statement  <<getPistonsWithoutComp>> completed");

        myStm.execute();
        System.out.println("Stored procedure << getPistonsWithoutComp >> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getPistonsWithoutCompAndDiameter(Double pinDiameter , String model , String brand , String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Without_Compression_Diameter( ? , ? , ? , ?)");
        myStm.setDouble(1, pinDiameter);
        myStm.setString(2, model);
        myStm.setString(3, brand);
        myStm.setString(4, stroke);
        System.out.println("Callable statement <<getPistonsWithoutCompAndDiameter>> completed");

        myStm.execute();
        System.out.println("Stored procedure <<getPistonsWithoutCompAndDiameter>> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getPistonsWithoutCompDiameterAndPinDiameter(String model , String brand , String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Without_Compression_Diameter_PinDiameter( ? , ? , ?)");
        myStm.setString(1, model);
        myStm.setString(2, brand);
        myStm.setString(3, stroke);
        System.out.println("Callable statement <<getPistonsWithoutCompDiameterAndPinDiameter>> completed");

        myStm.execute();
        System.out.println("Stored procedure <<<<getPistonsWithoutCompDiameterAndPinDiameter>> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getPistonsWithoutCompDiameterAndPinDiameterAndModel(String brand , String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Without_Compression_Diameter_PinDiameter_Model( ? , ?)");
        myStm.setString(1, brand);
        myStm.setString(2, stroke);
        System.out.println("Callable statement <<getPistonsWithoutCompDiameterAndPinDiameterAndModel>> completed");

        myStm.execute();
        System.out.println("Stored procedure <<<<getPistonsWithoutCompDiameterAndPinDiameterAndModel>> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getOnlyWithDiameter(Double diameter) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Only_With_Diameter(?)");
        myStm.setDouble(1, diameter);
        System.out.println("Callable statement <<getOnlyWithDiameter>> completed");

        myStm.execute();
        System.out.println("Stored procedure <<<<getOnlyWithDiameter>> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getOnlyWithStroke(String stroke) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Only_With_Stroke(?)");
        myStm.setString(1, stroke);
        System.out.println("Callable statement <<getOnlyWithStroke>> completed");


        myStm.execute();
        System.out.println("Stored procedure <<getOnlyWithStroke>> executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getOnlyWithBrand(String brand) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Only_With_Brand(?)");
        myStm.setString(1, brand);
        System.out.println("Callable statement <<getOnlyWithBrand> completed");

        myStm.execute();
        System.out.println("Stored procedure <<getOnlyWithBrand>  executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getOnlyWithCompression(String compression) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Only_With_Compression(?)");
        myStm.setString(1, compression);
        System.out.println("Callable statement <<getOnlyWithCompression> completed");

        myStm.execute();
        System.out.println("Stored procedure <<getOnlyWithCompression>  executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }
    public ResultSet getOnlyWithModel(String model) throws SQLException {
        CallableStatement myStm = conn.prepareCall("call get_Only_With_Model(?)");
        myStm.setString(1, model);
        System.out.println("Callable statement <<getOnlyWithModel> completed");

        myStm.execute();
        System.out.println("Stored procedure <<getOnlyWithModel>  executed.");

        //Get the Result set after execution.
        ResultSet rs = null;
        rs = myStm.getResultSet();

        return rs;
    }

}
