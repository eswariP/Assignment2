package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryBaseAdaptor extends BaseAdapter {

    ArrayList<HistoryItems> HistoryItemList;
    Context context;

    public HistoryBaseAdaptor(ArrayList<HistoryItems> historyItemList, Context context) {
        HistoryItemList = historyItemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return HistoryItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return HistoryItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup ) {

        //converts xml. file for base adopter row into a view on object
        LayoutInflater history_inflator= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v =history_inflator.inflate(R.layout.row_for_listview_adaptor,viewGroup,false);
        TextView historyItemName = v.findViewById(R.id.row_itemName);

        historyItemName.setText(HistoryItemList.get(position).getProduct_Name());

        TextView productPriceTextView = v.findViewById(R.id.row_itemPrice);
        productPriceTextView.setText(String.valueOf(HistoryItemList.get(position).getProductPrice()));

        TextView quantityInStockTextView = v.findViewById(R.id.row_quantity);
        quantityInStockTextView.setText(String.valueOf(HistoryItemList.get(position).getProduct_Quantity()));

        // Set data to the views
        return v;


    }

}
