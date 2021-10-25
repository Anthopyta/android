package com.idhamadileksono.belajarsharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtnama, txtalamat;
    Button save, cancel, load;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String session = "session";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnama = (EditText) findViewById(R.id.editNamaLengkap);
        txtalamat = (EditText) findViewById(R.id.editAlamat);

        save = (Button) findViewById(R.id.btnSave);
        cancel = (Button) findViewById(R.id.btnCancel);
        load = (Button) findViewById(R.id.btnLoad);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(session, MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("NamaLengkap", txtnama.getText().toString());
                editor.putString("Alamat", txtalamat.getText().toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_LONG).show();

                //Reset
                txtnama.setText("");
                txtalamat.setText("");

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.remove("NamaLengkap");
                editor.remove("Alamat");
                editor.apply();

                txtnama.setText("");
                txtalamat.setText("");

                Toast.makeText(MainActivity.this, "Remove", Toast.LENGTH_LONG).show();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(session, MODE_PRIVATE);
                txtnama.setText(sharedPreferences.getString("NamaLengkap", " "));
                txtalamat.setText(sharedPreferences.getString("Alamat", " "));
            }
        });

        Toast.makeText(MainActivity.this, "Load it", Toast.LENGTH_SHORT).show();
    }
}
