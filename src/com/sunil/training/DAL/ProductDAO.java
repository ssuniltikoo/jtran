package com.sunil.training.DAL;

import com.sunil.training.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection con=null;
    private Statement stmt=null;
    private PreparedStatement prpStmt;
    private ResultSet rst=null;
    private static ArrayList<Product> products=null;

    public boolean InsertProductData(int productId,String productName,String productDescription,int catalogId){
        String sql = "insert into product(id,name,description,catalogid) values(?,?,?,?)";
        con = DBUtil.getInstance();
        boolean flag = false;
        try{
            if(con!=null){
                prpStmt = con.prepareCall(sql);
                prpStmt.setInt(1,productId);
                prpStmt.setString(2,productName);
                prpStmt.setString(3,productDescription);
                prpStmt.setInt(4,catalogId);
                prpStmt.execute();
                flag = true;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public ArrayList<Product> getAllProducts(){
        products = new ArrayList<>();
        String sql = "SELECT id,name,description,catalogid from product";
        con = DBUtil.getInstance();
        try{
            stmt = con.createStatement();
            rst=stmt.executeQuery(sql);
            while (rst.next()){ ;
                products.add(getProductFromResultSet(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }

    private Product getProductFromResultSet(int id, String name, String description,int catalogId){
        return new Product(id,name,description,catalogId);
    }

}
