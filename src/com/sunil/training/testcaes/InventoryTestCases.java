package com.sunil.training.testcaes;

import com.sunil.training.inventorydao.InventoryDAO;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class InventoryTestCases {
    InventoryDAO InventorySystem= null;


    @Before
    public void setup(){
        InventorySystem = new InventoryDAO();
    }

    @After
    public void tearDown(){
        InventorySystem=null;
    }

    @Test
    public void IsProductAdded(){
        boolean result = InventorySystem.AddNewProduct(150,"LG Tv","Led tv from LG",30);
        assertEquals(result,true);
    }

    @Test
    public void ValidateCatalogisPresent(){
        boolean result = InventorySystem.AddNewProduct(250,"sony Tv","Led tv from sony",70);
        assertEquals(result,true);
    }

    @Test
    public void searchProduct(){
        int qty = InventorySystem.SearchStockUnits("iphonex");
        assertEquals(qty,102,0);
    }

}
