package com.rsiyun.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }
   /*public void isiSpinner(){
        String[] isi = {"Celcius to Reamur","Celcius to Farenheit","Celcius to Kelvin","Reamur to Celcius","Reamur to Farenheit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }*/
    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        if(etNilai.getText().toString().equals("")){
            etNilai.setError("Harus Diisi");
        }else{
         if(pilihan.equals("Celcius to Reamur")){
            cToR();
         }else if(pilihan.equals("Celcius to Farenheit")){
             cToF();
         }
      }
    }
    public void cToR(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0)*suhu;
        tvHasil.setText(hasil+"");

    }
    public void cToF(){
        Toast.makeText(this, "Belum Dibuat", Toast.LENGTH_SHORT).show();
    }
}