package com.indonesiaandroidkejar.donatasrama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.R.attr.id;

public class Chocolate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatcoklat);


        Button button3=(Button)findViewById(R.id.beranda);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent b =new Intent(getApplicationContext(),Home.class);
                startActivity(b);
            }

        });
        Button button4=(Button)findViewById(R.id.lanjut);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent c=new Intent(getApplicationContext(),Snow.class);
                startActivity(c);
            }

        });

    }
}
