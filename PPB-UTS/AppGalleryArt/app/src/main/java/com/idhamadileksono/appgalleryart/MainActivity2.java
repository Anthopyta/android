package com.idhamadileksono.appgalleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras1 = getIntent().getExtras();
        String intent = extras1.getString("yourkey1");
        username = (TextView) findViewById(R.id.username);
        username.setText(intent);

    }
}