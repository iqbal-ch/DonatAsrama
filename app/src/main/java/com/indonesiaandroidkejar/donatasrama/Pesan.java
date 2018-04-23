package com.indonesiaandroidkejar.donatasrama;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pesan extends AppCompatActivity implements View.OnClickListener{
    private int total,quantitya,quantityb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        Button orderButton = (Button) findViewById(R.id.order_button);
        orderButton.setOnClickListener(this);
        Button incrementButton = (Button) findViewById(R.id.increment_button1);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usingCoklat()) {
                    quantitya = quantitya + 1;
                    updateQty1(quantitya);
                }else {
                    updateQty1(0);
                }
            }
        });

        Button decrementButton = (Button) findViewById(R.id.decrement_button1);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantitya<=0) return;
                quantitya = quantitya - 1;
                updateQty1(quantitya);
            }
        });
        Button incrementButton1 = (Button) findViewById(R.id.increment_button2);
        incrementButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usingSalju()) {
                    quantityb = quantityb + 1;
                    updateQty2(quantityb);
                }else {
                    updateQty2(0);
                }
            }
        });

        Button decrementButton1 = (Button) findViewById(R.id.decrement_button2);
        decrementButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantityb<=0) return;
                quantityb = quantityb- 1;
                updateQty2(quantityb);
            }
        });

    }
    private void updateQty1(int qty1) {
        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view1);
        qtyView.setText(String.valueOf(qty1));
    }
    private void updateQty2(int qty2) {
        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view2);
        qtyView.setText(String.valueOf(qty2));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.order_button) {
            int price = calculatePrice(quantitya,quantityb);
            String customerName = getCustomerName();
            String NoKamar = getNoKamar();
            sentOrderSummary(price,quantitya,quantityb,customerName,NoKamar);

        }
    }
    private int calculatePrice(int quantitya,int quantityb ) {
        int basePrice1=2000,basePrice2=1500;
        return quantitya * basePrice1 + quantityb*basePrice2;
    }
    private boolean usingCoklat(){
        CheckBox coklat = (CheckBox)findViewById(R.id.donat_coklat);
        return coklat.isChecked();
    }
    private boolean usingSalju(){
        CheckBox salju = (CheckBox)findViewById(R.id.donat_salju);
        return salju.isChecked();
    }
    private String getCustomerName() {
        EditText customerName=(EditText)findViewById(R.id.nama_input);
        return customerName.getText().toString();

    }
    private String getNoKamar() {
        EditText NoKamar=(EditText)findViewById(R.id.kamar_input);
        return NoKamar.getText().toString();

    }
    private String createOrderSummary(int price, int quantitya,int quantityb ,String customerName,String NoKamar) {
        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryView.setText (getString(R.string.order_summary,
                customerName,
                NoKamar,
                quantitya,
                quantityb,
                price));
        return (getString(R.string.order_summary,
                customerName,
                NoKamar,
                quantitya,
                quantityb,
                price));
    }
    private void sentOrderSummary(int price, int quantitya,int quantityb ,String customerName,String NoKamar){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:iqbalc666@gmail.com"));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(price, quantitya, quantityb, customerName, NoKamar));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else{
            Toast.makeText(this,"aplication not found", Toast.LENGTH_SHORT).show();
        }
    }

}
