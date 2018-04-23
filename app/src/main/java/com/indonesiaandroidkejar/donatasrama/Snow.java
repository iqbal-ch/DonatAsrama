package com.indonesiaandroidkejar.donatasrama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.id;

public class Snow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donatsalju);

        Button button5=(Button)findViewById(R.id.kembali);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent d =new Intent(getApplicationContext(),Chocolate.class);
                startActivity(d);
            }

        });

    }
}
