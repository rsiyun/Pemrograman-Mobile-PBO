package com.rsiyun.kalkulator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvhasil;
    EditText bil_1,bil_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        tvhasil=findViewById(R.id.tvHasil);
        bil_1=findViewById(R.id.et_bil1);
        bil_2=findViewById(R.id.et_bil2);

    }

    public void penjumlahan(View view) {
        if(bil_1.getText().toString().equals("")||bil_2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil1 = Double.parseDouble(bil_1.getText().toString());
            double bil2 = Double.parseDouble(bil_2.getText().toString());
            double hasil = bil1 + bil2;
            tvhasil.setText(hasil + "");
        }
    }

    public void perkalian(View view) {
        if(bil_1.getText().toString().equals("")||bil_2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil1 = Double.parseDouble(bil_1.getText().toString());
            double bil2 = Double.parseDouble(bil_2.getText().toString());
            double hasil = bil1 * bil2;
            tvhasil.setText(hasil + "");
        }
    }

    public void pembagian(View view) {
        if(bil_1.getText().toString().equals("")||bil_2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil1 = Double.parseDouble(bil_1.getText().toString());
            double bil2 = Double.parseDouble(bil_2.getText().toString());
            double hasil = bil1 / bil2;
            tvhasil.setText(hasil + "");
        }
    }

    public void pengurangan(View view) {
        if(bil_1.getText().toString().equals("")||bil_2.getText().toString().equals("")){
            Toast.makeText(this, "Ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil1 = Double.parseDouble(bil_1.getText().toString());
            double bil2 = Double.parseDouble(bil_2.getText().toString());
            double hasil = bil1 - bil2;
            tvhasil.setText(hasil + "");
        }
    }
}