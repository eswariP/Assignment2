package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HistoryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);
        setTitle("purchase Details");
        TextView historyDetails =findViewById(R.id.historyDetails);
       // HistoryItems historyobj = getIntent().getSerializableExtra("historyobj");
        HistoryItems historyobj = (HistoryItems) getIntent().getSerializableExtra("historyobj");
        historyDetails.setText("product:"+historyobj.getProduct_Name()+"\n" +"qunatity:"+historyobj.getProduct_Quantity()
                +"\n"+"purchaseDate:"+historyobj.getPurchase_Date());
    }

}