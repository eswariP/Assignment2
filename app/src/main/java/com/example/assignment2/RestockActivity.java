package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText restockQnt;
    Button restockOk,restockCancel;
    ListView ProductList;
    int selectItemIndex=-1;
   // ArrayList<ProductItem> restock;
    ProductItemBaseAdaptor restockAdaptor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        restockQnt = findViewById(R.id.quantityEdittext);
        restockOk = findViewById(R.id.OkButton);
        restockCancel = findViewById(R.id.CancelButton);
        restockQnt.setOnClickListener(this);
        restockOk.setOnClickListener(this);
        restockCancel.setOnClickListener(this);

        ProductList= findViewById(R.id.restockList);

        restockAdaptor = new ProductItemBaseAdaptor(((myApp) getApplication()).getAppProductList(), this);

        ProductList.setAdapter(restockAdaptor);
        ProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

              selectItemIndex=+position;

            }
        });
setTitle("Restock Items");

    }
    @Override
    public void onClick(View v) {
        int butValue = ((Button) v).getId();
        switch (butValue) {
            case R.id.OkButton:

                boolean editTextIsEmpty =restockQnt.getText().toString().isEmpty();
                if(!editTextIsEmpty && selectItemIndex!=-1) {
                    int newStockQnt = Integer.parseInt(restockQnt.getText().toString());
                    int PresentQnt = ((myApp) getApplication()).getAppProductList().get(selectItemIndex).getQntInStock();
                    int reviseQnt = PresentQnt + newStockQnt;
                    ((myApp) getApplication()).getAppProductList().get(selectItemIndex).setQntInStock(reviseQnt);
                    restockAdaptor.ProductList= ((myApp) getApplication()).getAppProductList();
                    restockAdaptor.notifyDataSetChanged();
                    restockQnt.setText("");
                    selectItemIndex = -1;
                }
                    else {
                    Toast.makeText(this, "all fields are must be filled", Toast.LENGTH_SHORT).show();
                    }
                break;

                    case R.id.CancelButton:
                     restockQnt.setText("");
                     selectItemIndex=-1;
                Intent fromRestock = new Intent(RestockActivity.this, MainActivity.class);
                startActivity(fromRestock);
        }


    }
}
