package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView orderfood,callwaitor,paybills,ordernow,ordernow1,submit,feedback,vieworders;
    ImageView imageorderfood,imagecallwaitor,imagepaybills,imgpizza,imgburger,imgchicken,imgroll,imgcoffee,imgpaneer;
    EditText editfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        orderfood = findViewById(R.id.orderfood);
        callwaitor = findViewById(R.id.callwaitor);
        paybills = findViewById(R.id.paybill);
        imageorderfood = findViewById(R.id.imageView);
        imagecallwaitor = findViewById(R.id.imageView2);
        imagepaybills = findViewById(R.id.imageView3);
        ordernow = findViewById(R.id.orderfood1);
        ordernow1 = findViewById(R.id.orderfood2);
        submit = findViewById(R.id.submitfeedback);
        editfeedback = findViewById(R.id.editfeedback);
        feedback = findViewById(R.id.feedbackdone);
        imgpizza = findViewById(R.id.imageView6);
        imgburger = findViewById(R.id.imageView7);
        imgchicken = findViewById(R.id.imageView8);
        imgroll = findViewById(R.id.imageView9);
        imgcoffee = findViewById(R.id.imageView10);
        imgpaneer = findViewById(R.id.imageView11);
        vieworders = findViewById(R.id.vieworders);

        vieworders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Allorders.class);
                startActivity(i);
            }
        });
        feedback.setVisibility(View.INVISIBLE);
        orderfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imageorderfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        callwaitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,callwaiters.class);
                startActivity(i);
            }
        });
        imagecallwaitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,callwaiters.class);
                startActivity(i);
            }
        });
        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        paybills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,paybill.class);
                startActivity(i);
            }
        });
        imagepaybills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,paybill.class);
                startActivity(i);
            }
        });
        ordernow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });

        imgpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imgburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imgchicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imgcoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imgpaneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });
        imgroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Listoffooditems.class);
                startActivity(i);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editfeedback.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Feed Back is Empty", Toast.LENGTH_SHORT).show();
                }else {
                    editfeedback.setVisibility(View.INVISIBLE);
                    feedback.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}