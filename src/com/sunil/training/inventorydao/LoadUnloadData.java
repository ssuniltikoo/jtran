package com.sunil.training.inventorydao;

import com.sunil.training.DAL.ProductDAO;
import com.sunil.training.entity.Product;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.nio.file.Paths.get;

public class LoadUnloadData {
    File file;

    /**
     * <p> Save/storing all memory data in files  for collection</p>
     *
     * @param objdata
     * @param fileName
     * @return
     */
    public  boolean SaveData(Collection objdata, String fileName){
        boolean flag = false;
        try{
            String path = System.getProperty("user.dir")+"\\src\\datafiles\\" + fileName +".dat";
            file = new File(path);
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(objdata);
            out.flush();
            out.close();
            fout.close();
            flag = true;
        }catch (IOException  e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return flag;
    }

    /**
     *<p> Store/ave   Map data type structure in file</p>
     * @param objData
     * @param fileName
     * @return
     */
    public boolean SaveData(Map objData,String fileName){
        try{
            String path = System.getProperty("user.dir")+"\\src\\datafiles\\" + fileName +".dat";
            file = new File(path);
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(objData);
            out.flush();
            out.close();
            fout.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }



    /**
     *
     *
     * @param fileName
     * @return
     */
    /*public Collection LoadPreviousData(String fileName) {
        Object data=null;
        try{
            String path = System.getProperty("user.dir")+"\\src\\datafiles\\" + fileName+".dat";
            //String path = "C:\\Users\\shreeram\\Desktop\\inventory\\product.dat";
            file = new File(path);
            if(file.exists()) {
                FileInputStream iStream = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(iStream);
                data = objIn.readObject();
                //System.out.println(data);
                objIn.close();
                iStream.close();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return (Collection) data;
    }*/

    public Object LoadData(String fileName) {
        Object data=null;
        try{
            String path = System.getProperty("user.dir")+"\\src\\datafiles\\" + fileName+".dat";
            //String path = "C:\\Users\\shreeram\\Desktop\\inventory\\product.dat";
            file = new File(path);
            if(file.exists()) {
                FileInputStream iStream = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(iStream);
                data = objIn.readObject();
                //System.out.println(data);
                objIn.close();
                iStream.close();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return data;
    }

    public void SaveProductDataToDB(List<Product> data){
        ProductDAO product = new ProductDAO();
        boolean flag = false;
        for(Product productData :data ){
            flag =product.InsertProductData(productData.getId(),productData.getName(),productData.getDescription(),productData.getCatalogId());
            if(!flag)break;
        }
    }
    public List<Product> LoadProductData(){
        ProductDAO product = new ProductDAO();
        return product.getAllProducts();

    }





}
