package com.example.assignment2;

import java.io.Serializable;

public class ProductItem implements Serializable {
    String itemName;
    Double itemPrice;
    int qntInStock;
    private int purchasedQuantity;
    public ProductItem(String itemName, Double itemPrice, int qntInStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.qntInStock = qntInStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQntInStock() {
        return qntInStock;
    }

    public void setQntInStock(int qntInStock) {
        this.qntInStock = qntInStock;
    }


}
