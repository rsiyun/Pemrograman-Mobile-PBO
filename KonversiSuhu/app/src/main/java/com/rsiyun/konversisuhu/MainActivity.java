package com.rsiyun.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        isiSpinner();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
    }
    public void isiSpinner(){
        String[] isi = {"Celcius to Reamur","Celcius to Farenheit","Celcius to Kelvin","Reamur to Celcius","Reamur to Farenheit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        System.out.println(pilihan);
    }
}