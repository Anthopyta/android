package com.idhamadileksono.applogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class daftarActivity extends AppCompatActivity {
    private EditText nama,username,pass;
    SharedPreferences save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        nama = findViewById(R.id.daftar_nama);
        username = findViewById(R.id.daftar_username);
        pass = findViewById(R.id.daftar_pass);
        save = getSharedPreferences("login_key", MODE_PRIVATE);
    }
    public void Simpan(View view) {
        String saved_nama = nama.getText().toString();
        String saved_username = username.getText().toString();
        String saved_pass = pass.getText().toString();

        SharedPreferences.Editor editor = save.edit();
        editor.putString("nama", saved_nama);
        editor.putString("username", saved_username);
        editor.putString("pass", saved_pass);
        editor.apply();
        Toast.makeText(this, "Akun Terdaftar ! Silakan Login !",Toast.LENGTH_LONG).show();
    }
    public void reset(View view) {
        nama.setText("");
        username.setText("");
        pass.setText("");
    }
    public void gotologin(View view) {
        Intent gotologin = new Intent(this, MainActivity.class);
        startActivity(gotologin);
    }
}
