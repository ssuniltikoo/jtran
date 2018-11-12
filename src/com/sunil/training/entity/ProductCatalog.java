package com.sunil.training.entity;

import java.io.Serializable;

public class ProductCatalog implements Serializable{
    private int id;
    private String name;

    public ProductCatalog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
