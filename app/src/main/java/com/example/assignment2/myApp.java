package com.example.assignment2;

import android.app.Application;

import java.util.ArrayList;

public class myApp extends Application {
    ArrayList<ProductItem> appProductList;
ArrayList<HistoryItems>appHistoryList=new ArrayList<HistoryItems>(0);

    public ArrayList<ProductItem> getAppProductList() {
        if(appProductList==null) {
            appProductList = new ArrayList<>(3);
            appProductList.add(new ProductItem("pants", 25.0, 50));
            appProductList.add(new ProductItem("shoes", 20.0, 70));
            appProductList.add(new ProductItem("hats",40.0,50) );
        }
        return appProductList;
    }
    public ArrayList<HistoryItems>getAppHistoryList(){
        return appHistoryList;
    }
    public void addNewHistoryItem(HistoryItems newHistoryItem){
        appHistoryList.add(newHistoryItem);
    }
}
