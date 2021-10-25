package com.idhamadileksono.noteinternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.InputMismatchException;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button Save, Load;
    private static final String FileName = "tes.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        Save = (Button) findViewById(R.id.btnSave);
        Load = (Button) findViewById(R.id.btnLoad);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = editText.getText().toString();
                FileOutputStream fos = null;

                try {
                    fos = openFileOutput(FileName, MODE_PRIVATE);
                    fos.write(Text.getBytes());

                    editText.getText().clear();
                    Toast.makeText(MainActivity.this,"Save To " + getFilesDir() + "/" + FileName, Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null);
                        try {
                            fos.close();
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                }
            }
        });

        Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;

                try {
                    fis = openFileInput(FileName);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text;

                    while ((text = br.readLine()) != null){
                        sb.append(text).append('\n');
                    }

                    editText.setText((sb.toString()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (fis != null){
                        try {
                            fis.close();
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}