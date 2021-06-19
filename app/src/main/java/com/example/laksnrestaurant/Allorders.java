package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laksnrestaurant.Adapter.Orderadapter;
import com.example.laksnrestaurant.Model.Ordermodel;

import java.util.ArrayList;

public class Allorders extends AppCompatActivity {
    StringBuilder data21,totalpc;
    TextView name,table,total,callwaitor,paybill;
    RecyclerView recyclerView;
    String strtot1 = "";
    int sum1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allorders);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recycle12);
        name = findViewById(R.id.name1);
        table = findViewById(R.id.tableno1);
        Ordermodel ordermodel = new Ordermodel();
        name.setText(getIntent().getStringExtra("getname"));
        table.setText(getIntent().getStringExtra("gettable"));
        total = findViewById(R.id.totalall);
        callwaitor = findViewById(R.id.callwaiter);
        paybill = findViewById(R.id.paybill);
        data21 = new StringBuilder();
        totalpc = new StringBuilder();


        DBHelper helper1 = new DBHelper(this);
        ArrayList<Ordermodel> list = helper1.getorders();

        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.gettotalptice();
        while (cursor.moveToNext()){
            data21.append("a").append(cursor.getString(4));
        }


        Orderadapter orderadapter = new Orderadapter(list,this);
        recyclerView.setAdapter(orderadapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Allorders.this, com.example.laksnrestaurant.paybill.class);
                startActivity(i);
            }
        });
        callwaitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Allorders.this,callwaiters.class);
                startActivity(i);
            }
        });

        for(int i=0;i<data21.toString().length();i++)
        {
            if(data21.toString().charAt(i)>='0' && data21.toString().charAt(i)<='9')
            {
                strtot1+= data21.toString().charAt(i);
            }
            else
            {
                if(strtot1.length()>0)
                    sum1+=Integer.parseInt(strtot1);
                strtot1="";
            }
        }
        if(strtot1.length()>0)
            sum1+=Integer.parseInt(strtot1);
        String hi = String.valueOf(sum1);
        total.setText(hi);

    }

}