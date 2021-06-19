package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.laksnrestaurant.Adapter.Foodadapter;

import java.util.ArrayList;
import java.util.List;

public class Placeorder extends AppCompatActivity {
    public TextView selecteditem,selectedprice,total,confirm;
    EditText name,tableno;
   public StringBuilder str1,str2;
   String strtot = "";
   Integer sum =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeorder);
        getSupportActionBar().hide();
        str1 = new StringBuilder();
        str2 = new StringBuilder();

        DBHelper helper = new DBHelper(this);

        selecteditem = findViewById(R.id.textView11);
        selectedprice = findViewById(R.id.textView12);
        total = findViewById(R.id.total);
        name = findViewById(R.id.name);
        tableno = findViewById(R.id.tableno);
        confirm = findViewById(R.id.confirm);

        Intent intent = getIntent();
        String food = intent.getStringExtra("foodname");
        String price = intent.getStringExtra("foodprice");
        String total1 = intent.getStringExtra("total");
        selecteditem.setText(food);
        selectedprice.setText(price);


        for(int i=0;i<total1.length();i++)
        {
            if(total1.charAt(i)>='0' && total1.charAt(i)<='9')
            {
                strtot+= total1.charAt(i);
            }
            else
            {
                if(strtot.length()>0)
                    sum+=Integer.parseInt(strtot);
                strtot="";
            }
        }
        if(strtot.length()>0)
            sum+=Integer.parseInt(strtot);
        String hi = String.valueOf(sum);
         total.setText(hi);



         confirm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                boolean isInserted = helper.insertorder(name.getText().toString(),
                         tableno.getText().toString(),selecteditem.getText().toString(),selectedprice.getText().toString());
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(Placeorder.this, "Name Cannot be Empty", Toast.LENGTH_SHORT).show();
                }else if(tableno.getText().toString().isEmpty()){
                    Toast.makeText(Placeorder.this, "TableNo Canot be Empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(isInserted){
                        Intent intent1 = new Intent(Placeorder.this,OrderedPlaced.class);
                        intent1.putExtra("name",name.getText().toString());
                        intent1.putExtra("table",tableno.getText().toString());
                        intent1.putExtra("food",food);
                        intent1.putExtra("price",price);
                        intent1.putExtra("total",hi);
                        Toast.makeText(Placeorder.this, "Order is in Process Please wait", Toast.LENGTH_SHORT).show();
                        startActivity(intent1);
                        finish();
                    }else{
                        Toast.makeText(Placeorder.this, "Error in Order", Toast.LENGTH_SHORT).show();
                    }
                }

             }
         });


    }



}