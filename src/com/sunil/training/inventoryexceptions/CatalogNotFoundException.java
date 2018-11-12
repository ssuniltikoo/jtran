package com.sunil.training.inventoryexceptions;

public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(){
        super("Catalog Not found Exception");
    }

    public CatalogNotFoundException(String msg){
        super(msg);
    }
}
