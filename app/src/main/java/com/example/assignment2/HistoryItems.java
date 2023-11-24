package com.example.assignment2;

import java.io.Serializable;

public class HistoryItems implements Serializable {
    String product_Name;
    int product_Quantity;
    String purchase_Date;
    double productPrice;
    public HistoryItems(String product_Name, int product_Quantity, String purchase_Date, double productPrice) {
        this.product_Name = product_Name;
        this.product_Quantity = product_Quantity;
        this.purchase_Date = purchase_Date;
        this.productPrice = productPrice;
    }


    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public int getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(int product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public String getPurchase_Date() {
        return purchase_Date;
    }

    public void setPurchase_Date(String purchase_Date) {
        this.purchase_Date = purchase_Date;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }




}
