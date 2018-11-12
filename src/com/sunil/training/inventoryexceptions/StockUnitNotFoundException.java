package com.sunil.training.inventoryexceptions;

public class StockUnitNotFoundException extends RuntimeException {
    public StockUnitNotFoundException(){
        super("Stock Unit NOt found Exception");
    }

    public StockUnitNotFoundException(String msg){
        super(msg);
    }
}
