package com.sunil.training.inventoryexceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){
        super("Product not found in Inventory system");
    }
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
