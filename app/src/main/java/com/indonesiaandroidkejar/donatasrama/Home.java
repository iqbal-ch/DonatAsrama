package com.indonesiaandroidkejar.donatasrama;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button1=(Button)findViewById(R.id.pesan);



        button1.setOnClickListener(new View.OnClickListener() {



            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent i =new Intent(getApplicationContext(),Pesan.class);

                startActivity(i);
            }

        });
        Button button8=(Button)findViewById(R.id.button);



        button8.setOnClickListener(new View.OnClickListener() {



            public void onClick(View arg0) {

                // TODO Auto-generated method stub

                Intent m=new Intent(getApplicationContext(),Chocolate.class);

                startActivity(m);
            }

        });

    }
}
