package com.sunil.training.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






public class DBUtil {
    private static Connection con;
    private static final String url="Jdbc:mysql://localhost:3306/inventory";//"Jdbc:mysql://localhost:3306/world"
    private static final String userName = "root";
    private static final String password = "";

    private DBUtil(){}

    public static Connection getInstance(){
        if(con==null){
            try{
                con = DriverManager.getConnection(url,userName,password);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
        return con;
    }

    public static boolean IsDBDown(){
        boolean dflag= false;
        if(con!=null){
            dflag=true;
        }
        return dflag;
    }
}
