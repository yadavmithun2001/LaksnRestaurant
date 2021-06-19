package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laksnrestaurant.Adapter.Foodadapter;
import com.example.laksnrestaurant.Model.Foodmodel;

import java.util.ArrayList;
import java.util.List;

public class Listoffooditems extends AppCompatActivity {
     RecyclerView recyclerView;
     Integer counter = 0 ,ps;
     TextView placeorder;
     Dialog dialog;
     TextView selectedfood,price,proceed,cancel;
     public StringBuilder data1,data2,data3;
     public Placeorder pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listoffooditems);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerview);
        placeorder = findViewById(R.id.placeorder);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.confirmdialog);
        selectedfood = dialog.findViewById(R.id.textView13);
        data1 = new StringBuilder();
        data2 = new StringBuilder();
        data3 = new StringBuilder();
        price = dialog.findViewById(R.id.textView14);
        proceed = dialog.findViewById(R.id.textView12);
        cancel = dialog.findViewById(R.id.textView10);
        this.pc = pc;
        ArrayList<Foodmodel> list = new ArrayList<>();
        list.add(new Foodmodel(R.drawable.pizza,"PIZZA","200"));
        list.add(new Foodmodel(R.drawable.burger,"BURGER","60"));
        list.add(new Foodmodel(R.drawable.chicken,"CHICKEN","120"));
        list.add(new Foodmodel(R.drawable.kadaipaneer,"PANEER","100"));
        list.add(new Foodmodel(R.drawable.cofee,"COFFEE","20"));
        list.add(new Foodmodel(R.drawable.tea,"TEA","15"));
        list.add(new Foodmodel(R.drawable.egg,"EGG ROLL","20"));
        list.add(new Foodmodel(R.drawable.mineralwater,"MINERAL WATER","20"));

        Foodadapter foodadapter = new Foodadapter(list,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(foodadapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                selectedfood.setText(data1.toString());
                price.setText(data2.toString());
                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(selectedfood.getText().toString().isEmpty()){
                            Toast.makeText(Listoffooditems.this, "Please Select ATLEAST One Item in the List", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Intent i = new Intent(Listoffooditems.this,Placeorder.class);
                            i.putExtra("foodname",data1.toString());
                            i.putExtra("foodprice",data2.toString());
                            i.putExtra("total",data3.toString());
                            startActivity(i);
                            finish();

                        }
                    }
                });
            }
        });

    }

    public void selection(int position) {
        counter++;
    }

    public void getdata(StringBuilder stringBuilder, StringBuilder stringBuilder1, StringBuilder stringBuilder2) {
        data1.append(stringBuilder.toString());
        data2.append(stringBuilder1.toString());
        data3.append(stringBuilder2.toString());

    }
}