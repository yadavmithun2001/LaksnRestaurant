package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class OrderedPlaced extends AppCompatActivity {
    TextView timer,name,tableno,paybill,orderagain,food,price,totalprice,vieworders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_placed);
        getSupportActionBar().hide();
        timer = findViewById(R.id.textView18);
        name = findViewById(R.id.name);
        tableno = findViewById(R.id.tableno);
        paybill = findViewById(R.id.paybill);
        orderagain = findViewById(R.id.orderagain);
        food = findViewById(R.id.namefood);
        price = findViewById(R.id.price);
        vieworders = findViewById(R.id.vieworders);
        totalprice = findViewById(R.id.totalprice);

        new CountDownTimer(500000, 1000) {
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                timer.setText(f.format(min) + ":" + f.format(sec));
            }
            public void onFinish() { timer.setText("Time Out, Please wait");
            }
        }.start();

        name.setText(getIntent().getStringExtra("name"));
        tableno.setText(getIntent().getStringExtra("table"));
        food.setText(getIntent().getStringExtra("food"));
        price.setText(getIntent().getStringExtra("price"));
        totalprice.setText(getIntent().getStringExtra("total"));

        orderagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderedPlaced.this,Listoffooditems.class);
                startActivity(i);
                finish();
            }
        });
        paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderedPlaced.this, com.example.laksnrestaurant.paybill.class);
                startActivity(i);
            }
        });
        vieworders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderedPlaced.this,Allorders.class);
                startActivity(i);
            }
        });


    }
}