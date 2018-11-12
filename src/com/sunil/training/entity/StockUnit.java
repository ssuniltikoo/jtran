package com.sunil.training.entity;

import java.io.Serializable;

public class StockUnit implements Serializable {
    private int unitId;
    private int productId;
    private int quantity;

    public StockUnit(int unitId, int productId, int quantity) {
        this.unitId = unitId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockUnit{" +
                "unitId=" + unitId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
