package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductItemBaseAdaptor extends BaseAdapter {

    ArrayList<ProductItem> ProductList;
    Context context;

    public ProductItemBaseAdaptor(ArrayList<ProductItem> productList, Context context) {
        ProductList = productList;
        this.context = context;
    }

    @Override

    public int getCount() {
        return ProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return ProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //converts xml. file for base adopter row into a view on object
        LayoutInflater inflator= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v =inflator.inflate(R.layout.row_for_listview_adaptor,viewGroup,false);

        TextView productNameTextView =v.findViewById(R.id.row_itemName);
        productNameTextView.setText(ProductList.get(position).getItemName());

        TextView productPriceTextView = v.findViewById(R.id.row_itemPrice);
        productPriceTextView.setText(String.valueOf(ProductList.get(position).getItemPrice()));

        TextView quantityInStockTextView = v.findViewById(R.id.row_quantity);
        quantityInStockTextView.setText(String.valueOf(ProductList.get(position).getQntInStock()));

        // Set data to the views
        return v;
    }
}


