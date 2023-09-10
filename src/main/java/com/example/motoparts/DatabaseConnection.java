package com.example.motoparts;
import data.classes.Piston;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    //Class for initializing db connection.
    public Connection conn;

    public Connection getDBConnection(){
        String databaseName = "MotoParts";
        String databaseUser = "root";
        String databasePassword = "pergaminos007";
        String url = "jdbc:mysql://localhost:3306/motoparts";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url , databaseUser , databasePassword );
            System.out.println("Connection established");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }


    public static void main(String args[]) throws SQLException {
//        //Initialize database connection.
//        DatabaseConnection db = new DatabaseConnection();
//        Connection conn = db.getDBConnection();
//        //Create callable statement to stored procedure.
//        CallableStatement myStm = conn.prepareCall("call get_Pistons(?)");
//        System.out.println("Callable statement completed");
//        //Setting parameters of callable statement and executing.
//        myStm.registerOutParameter(1,Types.DOUBLE);
//        myStm.setDouble(1,40.2);
//        myStm.execute();
//        System.out.println("Stored procedure executed.");
//        //Get the Result set after execution.
//        ResultSet rs = null;
//        rs = myStm.getResultSet();
//        ArrayList<String> pistonData = new ArrayList<>();
//        while(rs.next()){
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));
        }


    }


