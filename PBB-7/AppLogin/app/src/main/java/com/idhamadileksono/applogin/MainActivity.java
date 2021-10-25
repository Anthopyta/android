package com.idhamadileksono.applogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.login_username);
        pass = findViewById(R.id.login_password);
        SharedPreferences pref = getSharedPreferences("login_key",
                MODE_PRIVATE);
    }

    public void login(View view) {
        String user = username.getText().toString();
        String pwd = pass.getText().toString();
        SharedPreferences pref = getSharedPreferences("login_key",
                MODE_PRIVATE);
        String saved_username = pref.getString("username", "");
        String saved_pass = pref.getString("pass", "");
        if(user.equals(saved_username) && pwd.equals(saved_pass)){
            Intent login = new Intent(this, Dashboard.class);
            startActivity(login);
        }
        else{
            Toast.makeText(this, "Username atau Password tidak sesuai/terdaftar", Toast.LENGTH_LONG).show();
        }
    }
    public void daftar(View view) {
        Intent daftar = new Intent(this, daftarActivity.class);
        startActivity(daftar);
    }
}