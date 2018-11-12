package com.sunil.training.inventorydao;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import com.sunil.training.DAL.DBUtil;
import com.sunil.training.entity.Product;
import com.sunil.training.entity.ProductCatalog;
import com.sunil.training.entity.StockUnit;
import com.sunil.training.inventoryexceptions.CatalogNotFoundException;
import com.sunil.training.inventoryexceptions.StockUnitNotFoundException;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class InventoryDAO {
    private static List<Product> products =null;
    private static Set<ProductCatalog> catalogs = null;
    private static Map<Integer,StockUnit> stockUnits= null;
    private static boolean dbflag;
    static{
        products = new ArrayList<>();
        catalogs = new HashSet<>();
        stockUnits = new HashMap<>();
        //If DB is down , the data will be loaded from filesystem
        dbflag = DBUtil.IsDBDown();
        LoadUnloadData ld = new LoadUnloadData();
        if(!dbflag) {
            Object temp = ld.LoadData("products");// load Product data
            if(temp!=null)
                products.addAll((List)temp);
            temp = null;
            temp = ld.LoadData("catalogs");// load catalog data
            if(temp!=null)
                catalogs.addAll((Set)temp);
            temp=null;
            temp =ld.LoadData("stockUnits");
            if(temp!=null)
                stockUnits.putAll((Map)temp);
        }else{
                products.addAll(ld.LoadProductData());
        }
        //hard code data
        /*products.add(new Product(101,"iphonex","apple phone",10));
        products.add(new Product(102,"iphone se","apple phone",10));
        products.add(new Product(201,"moto x","moto phone",20));
        products.add(new Product(202,"moto g","moto phone",20));
        products.add(new Product(301,"redmi x","xiomi phone",30));
        products.add(new Product(302,"note mi","xiomi phone",30));
        products.add(new Product(401,"nokia","nokia phone",40));
        catalogs.add(new ProductCatalog(10,"Iphone Catalog"));
        catalogs.add(new ProductCatalog(20,"Lenovo Catalog"));
        catalogs.add(new ProductCatalog(30,"Samsung Catalog"));
        catalogs.add(new ProductCatalog(40,"Nokia Catalog"));*/
    }

    /**
     * <p> Add new product to Product list</p>
     * <p> System will check whether Catalog is present or noy</p>
     * @param productId
     * @param productName
     * @param description
     * @param catalogId
     * @return
     */
    public boolean AddNewProduct(int productId, String productName, String description, int catalogId ){
        boolean flag=false;
        if((IsCatalogPresent(catalogId))) // if catalog is present then only product will be added
            flag = products.add(new Product(productId,productName,description,catalogId));
        //else

          // throw new CatalogNotFoundException("Catalog id " + catalogId +" not found.");
        return flag;
    }

    public boolean AddNewStock(int  productid,int quantity,int stockunit){
        boolean flag = false;
        for(Product product:products){
            if(product.getId()==productid) {
                stockUnits.put(stockunit, new StockUnit(stockunit, productid, quantity));
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Product> ListAllProducts(){
        return products;
    }

    public Collection<StockUnit> ListAllStockUnitsWithQuantity(){
        Collection<StockUnit> units =stockUnits.values();
        return units;
    }

    public int SearchStockUnits(String productName){
        int productId= getProductID(productName);
        int stUnits = 0;
        if( productId >0){
            Collection<StockUnit> units =stockUnits.values();
            for(StockUnit unit:units){
                if(unit.getProductId()==productId)
                    stUnits+=unit.getQuantity();
            }
        }else{
            throw new StockUnitNotFoundException("Product Not Found in Stock Unit");
        }
        return  stUnits;
    }

    private int getProductID(String productName){
        int productId=0;
        for(Product product:products){
            if(product.getName().equalsIgnoreCase(productName)){
                productId=product.getId();
                break;
            }
        }
        return productId;
    }

    private boolean IsCatalogPresent(int catalogId){
        boolean flag =false;
        for(ProductCatalog cat :catalogs){
            if(cat.getId()==catalogId){
                flag =true;
                break;}
        }
        return flag;
    }

    public void SaveData(){
        LoadUnloadData data = new LoadUnloadData();
        //save all data in memory to files
        data.SaveData(products,"products");
        data.SaveData(catalogs,"catalogs");
        data.SaveData(stockUnits,"stockUnits");
        // save all data to db
       // data.SaveProductDataToDB(products);
    }
}
