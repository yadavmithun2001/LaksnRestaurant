package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laksnrestaurant.Adapter.Orderadapter;
import com.example.laksnrestaurant.Model.Ordermodel;

import java.util.ArrayList;

public class paybill extends AppCompatActivity {
    TextView allitem,allprice,totalfood,tip,grandtotal,completepayment,done,cancel;
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder totalitem = new StringBuilder();
    StringBuilder totalprice = new StringBuilder();
    String strtot1 = "";
    int sum1 =0;
    Dialog dialog1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paybill);
        getSupportActionBar().hide();
        allitem = findViewById(R.id.allitem);
        allprice = findViewById(R.id.allprice);
        totalfood = findViewById(R.id.totalfoodprice);
        tip = findViewById(R.id.tip);
        grandtotal = findViewById(R.id.grandtotal);
        completepayment = findViewById(R.id.completepayment);
        dialog1 = new Dialog(this);
        dialog1.setContentView(R.layout.paymentdialog);
        done = dialog1.findViewById(R.id.done);
        cancel = dialog1.findViewById(R.id.cancel);
        progressBar = dialog1.findViewById(R.id.progressBar2);

        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.gettotalptice();
        while (cursor.moveToNext()){
            totalitem.append("\n").append(cursor.getString(3));
            totalprice.append("\n").append(cursor.getString(4));
            stringBuilder.append("a").append(cursor.getString(4));
        }

        for(int i=0;i<stringBuilder.toString().toString().length();i++)
        {
            if(stringBuilder.toString().toString().charAt(i)>='0' && stringBuilder.toString().toString().charAt(i)<='9')
            {
                strtot1+= stringBuilder.toString().toString().charAt(i);
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


        Double ttf = Double.parseDouble(hi);
        Double tips = (ttf*0.1);
        Double gntotal = ttf+tips;
        String ttfs = String.valueOf(ttf);
        String tipss = String.valueOf(tips);
        String gentotals = String.valueOf(gntotal);
        totalfood.setText(ttfs);
        tip.setText(tipss);
        grandtotal.setText(gentotals);
        allitem.setText(totalitem.toString());
        allprice.setText(totalprice.toString());

        completepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paybill.this, "CONFIRMING YOUR PAYMENT", Toast.LENGTH_SHORT).show();
                dialog1.show();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paybill.this, "PAYMNET DONE", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paybill.this, "PAYMENT CANCELLED", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });


    }
}