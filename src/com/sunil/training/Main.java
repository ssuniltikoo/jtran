package com.sunil.training;

import com.sunil.training.entity.Product;
import com.sunil.training.entity.StockUnit;
import com.sunil.training.inventorydao.InventoryDAO;
import com.sunil.training.inventorydao.LoadUnloadData;
import com.sunil.training.inventoryexceptions.ProductNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************** INVENTORY MANAGEMENT SYSTEM *************************");
        System.out.println("Menu to perform following actions \n  A. " +
                "Add New Product \n I. Add new stock for existing product \n  L. List All Products" +
                "\n P. List All stock Units(with quantity) \n S. Search for Stock Units by Product (User need to enter product name) \n Q. Quit  ");
        Scanner sc = new Scanner(System.in);
        InventoryDAO inventory = new InventoryDAO();
        do {

            switch (sc.next().toUpperCase()){
                case "A":
                    System.out.println("Enter details of product \n Product ID");
                    int productId =(Integer.parseInt(sc.next()));
                    System.out.println("Catalog Id : ");
                    int catalogId = (Integer.parseInt(sc.next()));
                    System.out.println("Product Name : ");
                    String productName = sc.next();
                    System.out.println("Product Description : ");
                    String productDescription = sc.next("[aA-zZ]+");
                    System.out.println("Adding product in ");
                    if(inventory.AddNewProduct(productId,productName,productDescription,catalogId))
                        System.out.println("Product Added Successfully");
                    else
                        System.out.println("Product not added..Please try again..");
                    System.out.println("Press Key to continue..");
                    break;

                case "I":
                    System.out.println("Stock Unit details :: \n stock unit id");
                    int stockUnitId = sc.nextInt();
                    System.out.println("stock unit product Id");
                    int StockProductId = sc.nextInt();
                    System.out.println("Quantity");
                    int stockQuantity = sc.nextInt();
                    if(inventory.AddNewStock(StockProductId,stockQuantity,stockUnitId))
                        System.out.println("Stock Unit added successfully");
                    else
                        System.out.println("Stock unit not added");
                    System.out.println("Press Key to continue..");
                    break;
                case "L":
                    List products =inventory.ListAllProducts();
                    if(!products.isEmpty())
                        for(Object product:products)
                            System.out.println(product);
                    else
                        System.out.println("No records found..");
                    System.out.println("Press Key to continue..");
                    break;
                case "P":
                    Collection<StockUnit> units =inventory.ListAllStockUnitsWithQuantity();
                    if(!units.isEmpty()){
                        for(StockUnit unit:units)
                            System.out.println(unit.getUnitId() + " : " +unit.getQuantity());
                    }
                    System.out.println("Press Key to perform action");
                    break;
                case "S":
                    System.out.println("Product Name");
                    String prodName = sc.next();
                    try {
                        int qty = inventory.SearchStockUnits(prodName);
                        System.out.println(prodName +"  ->   " + qty);
                    }catch(ProductNotFoundException e){
                        System.out.println("Product Name not found in inventory System");
                    }

                    System.out.println("Press Key to perform action");
                    break;
                case "Q":
                    inventory.SaveData();
                    System.out.println("Shutting down system....");
                    System.exit(0);
                    break;
                   default:
                        //System.out.println("Invalid key entered...Press valid key to perform action");
                        break;
            }
        }while(true);
    }
}
