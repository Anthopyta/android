package com.idhamadileksono.appayamku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public TextView card1, card2, card3, card4, card5, card6;
    private int total = 0;
    private int hargaAkhir;
    private int item1, item2, item3, item4, item5, item6;
    private TextView totalHarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card1 = findViewById(R.id.menu1);
        card2 = findViewById(R.id.menu2);
        card3 = findViewById(R.id.menu3);
        card4 = findViewById(R.id.menu4);
        card5 = findViewById(R.id.menu5);
        card6 = findViewById(R.id.menu6);
        totalHarga = (TextView) findViewById(R.id.totalharga);
    }
    public void tambahmenu1(View view) {
        item1 = Integer.parseInt(card1.getText().toString());
        hargaAkhir = total + item1;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
    public void tambahmenu2(View view) {
        item2 = Integer.parseInt(card2.getText().toString());
        hargaAkhir = total + item2;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
    public void tambahmenu3(View view) {
        item3 = Integer.parseInt(card3.getText().toString());
        hargaAkhir = total + item3;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
    public void tambahmenu4(View view) {
        item4 = Integer.parseInt(card4.getText().toString());

        hargaAkhir = total + item4;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
    public void tambahmenu5(View view) {
        item5 = Integer.parseInt(card5.getText().toString());
        hargaAkhir = total + item5;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
    public void tambahmenu6(View view) {
        item6 = Integer.parseInt(card6.getText().toString());
        hargaAkhir = total + item6;
        total = Integer.parseInt(String.valueOf(hargaAkhir));
        totalHarga.setText(String.valueOf(total));
    }
}