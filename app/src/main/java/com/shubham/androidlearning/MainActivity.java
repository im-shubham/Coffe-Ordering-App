package com.shubham.androidlearning;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Switch switchBtn;


    static  int x =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }else{
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        switchBtn=findViewById(R.id.switch_btn);
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button order_button = findViewById(R.id.orderNow_btn);
        Button increment_button = findViewById(R.id.increment_btn);
        Button decrement_button = findViewById(R.id.decrement_btn);
        TextView quantity_tv = findViewById(R.id.quantity_number_tv);
        TextView price_tv = findViewById(R.id.price_number_tv);

        increment_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                ++x;
                String text = String.valueOf(x);
                quantity_tv.setText(text);
                int value = 5*x;

                price_tv.setText(NumberFormat.getCurrencyInstance().format(value));

            }
        });
        decrement_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if(x>0){
                    x--;
                    String text = String.valueOf(x);
                    quantity_tv.setText(text);
                    int value = 5*x;

                    price_tv.setText(NumberFormat.getCurrencyInstance().format(value));
                }else{
                    Toast.makeText(getApplicationContext(),"Quantity can't be less than zero!!",Toast.LENGTH_LONG).show();
                }
            }
        });
        order_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Thanks For Your Order :)",Toast.LENGTH_LONG).show();
                quantity_tv.setText("0");
                price_tv.setText(NumberFormat.getCurrencyInstance().format(0));
                x=0;
            }
        });


    }




}