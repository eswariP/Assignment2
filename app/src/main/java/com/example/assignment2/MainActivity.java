package com.example.assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnC, btnBuy,btm;
    TextView selectedProduct, total, quantity;
    ListView ProductItemListview;
    String qty = "";
    int productIndex = -1;

    double total_sell_price = 0.0;
    boolean itemSelected = false;
    ProductItem currentProductItem = null;
    boolean ProductAvailable = false;
    ProductItemBaseAdaptor adaptor;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnC = findViewById(R.id.buttonCancel);
        btnBuy = findViewById(R.id.buy);
        selectedProduct = findViewById(R.id.selectedProductTextView);
        total = findViewById(R.id.Total);
        quantity = findViewById(R.id.quantity);
       btm= findViewById(R.id.manager);
       btm.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBuy.setOnClickListener(this);

        adaptor = new ProductItemBaseAdaptor(((myApp) getApplication()).getAppProductList(), this);

        ProductItemListview = findViewById(R.id.productItemList);
        ProductItemListview.setAdapter(adaptor);
        ProductItemListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                productIndex = position;
                currentProductItem = ((myApp) getApplication()).getAppProductList().get(productIndex);
                selectedProduct.setText(currentProductItem.getItemName());
                itemSelected =true;
                if(qty!=""){
                    total_sell_price =currentProductItem.getItemPrice()  * Integer.parseInt(qty);
                    total.setText(String.format("%.2f",total_sell_price));
                    total_sell_price= Double.parseDouble(String.format("%.2f",total_sell_price));

                }

            }

        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCancel:
                clearAllFields();


                break;
            case R.id.buy:

                if(itemSelected && qty != ""){
                //if (qty != "") {
                    int selectedQnt = Integer.parseInt(qty);
                    ProductAvailable = ValidateQnt(productIndex, selectedQnt);
                    if (ProductAvailable) {
                        purchaseItem(productIndex,selectedQnt);
                        productIndex=-1;
                        itemSelected = false;
                        qty="";
                    }else {
                        Toast.makeText(this,"Not enough quantity in stock.",Toast.LENGTH_LONG).show();
                    }

                } else{
                    Toast.makeText(this,"missing fields",Toast.LENGTH_SHORT).show();
                }
                    break;
            case R.id.manager:
                Intent i= new Intent(this,ManagerActivity.class);
                startActivity(i);

                break;
                    default:
                        String value = ((Button) v).getText().toString();
                        qty += value;
                        quantity.setText(qty);

                }
        }

    boolean ValidateQnt(int itemIndex, int wantedNoOfQnt){
            int availableQnt = ((myApp) getApplication()).getAppProductList().get(productIndex).getQntInStock();
            if (wantedNoOfQnt <= availableQnt) {
                return true;
            } else {
                return false;
            }
        }
    void clearAllFields ( ){
             productIndex=-1;
          itemSelected = false;
            selectedProduct.setText("");
            qty= "";
            quantity.setText("");
            total.setText("");
        }
        void purchaseItem(int stockIndex,int selectedQnt){
        int availableQnt= ((myApp)getApplication()).getAppProductList().get(productIndex).getQntInStock();
            ((myApp)getApplication()).getAppProductList().get(productIndex).setQntInStock(availableQnt-selectedQnt);

            total_sell_price =currentProductItem.getItemPrice()  * selectedQnt;
            total.setText(String.format("%.2f",total_sell_price));
            total_sell_price= Double.parseDouble(String.format("%.2f",total_sell_price));
            Date purchasedTime = Calendar.getInstance().getTime();
            HistoryItems newPurchase= new HistoryItems(currentProductItem.getItemName(),selectedQnt,purchasedTime.toString(),total_sell_price);
            ((myApp) getApplication()).addNewHistoryItem(newPurchase);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("you have Purchased"+selectedQnt+" "+ currentProductItem.getItemName()+"for"+total_sell_price);
            //clear all the fields if user clicks outside alert dialog window
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    clearAllFields();
                }
            });
            builder.create().show();
            adaptor.ProductList=((myApp) getApplication()).getAppProductList();
            adaptor.notifyDataSetChanged();
        }
}




