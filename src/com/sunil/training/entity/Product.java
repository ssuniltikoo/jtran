package com.sunil.training.entity;


import java.io.Serializable;

public class Product implements Serializable
{
    private int id;
    private String name;
    private String description;
    private int catalogId;

    public Product(int id, String name, String description, int catalogId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.catalogId = catalogId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", catalogId=" + catalogId +
                '}';
    }
}
