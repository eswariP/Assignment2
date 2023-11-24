package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<HistoryItems> HistoryItemList1;


    HistoryBaseAdaptor adapter;

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        listview = findViewById(R.id.historyListview); // Adapter View
        HistoryItemList1 = ((myApp) getApplication()).appHistoryList; // data
        adapter = new HistoryBaseAdaptor(HistoryItemList1, this);

        listview.setAdapter(adapter);
        setTitle("Purchase History");
     listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent toHistoryDetails =new Intent(HistoryActivity.this,HistoryDetailsActivity.class);
             HistoryItems historyobj =((myApp) getApplication()).appHistoryList.get(position);
             toHistoryDetails.putExtra("historyobj",historyobj);
             startActivity(toHistoryDetails);
         }
     });

    }
}