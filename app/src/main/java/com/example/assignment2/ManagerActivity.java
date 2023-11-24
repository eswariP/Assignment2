package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;
public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    Button historyButton, restockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.manager_actitvity);

        historyButton = findViewById(R.id.history);
        historyButton.setOnClickListener(this);
        restockButton = findViewById(R.id.restock);
        restockButton.setOnClickListener(this);
        setTitle("Manger Menu");
    }

    @Override
    public void onClick(View v) {
        int buttonId = ((Button) v).getId();
        switch (buttonId) {
            case R.id.history:
                Intent toHistory = new Intent(ManagerActivity.this, HistoryActivity.class);
                startActivity(toHistory);
                break;
            case R.id.restock:

                Intent toRestock = new Intent(ManagerActivity.this, RestockActivity.class);
                startActivity(toRestock);
                break;
        }


    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
