package com.idhamadileksono.apploginregistrasi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText nama = (EditText) findViewById(R.id.etNamalengkap);
        final EditText username = (EditText) findViewById(R.id.etNewUsername);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS",
                        MODE_PRIVATE);
                String namaLengkap = nama.getText().toString();
                String newUser = username.getText().toString();
                String newPassword = password.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(namaLengkap + newUser + newPassword + "data", newUser );
                editor.commit();
                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });
    }
}