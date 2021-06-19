package com.example.laksnrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class callwaiters extends AppCompatActivity {
    TextView details,entable,callwaitor;
    EditText entertable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callwaiters);
        getSupportActionBar().hide();
        details = findViewById(R.id.enterdetails);
        entable = findViewById(R.id.entable);
        entertable = findViewById(R.id.entertable);
        callwaitor = findViewById(R.id.callwaitor);
        callwaitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entertable.getText().toString().isEmpty()){
                    Toast.makeText(callwaiters.this, "Table Number Cannot be EMPTY", Toast.LENGTH_SHORT).show();
                }else {
                    entertable.setVisibility(View.GONE);
                    callwaitor.setVisibility(View.INVISIBLE);
                    entable.setText("Please Wait Few moments...");
                    details.setText("Waitor is Assigne to your Table");
                }
            }
        });
    }
}