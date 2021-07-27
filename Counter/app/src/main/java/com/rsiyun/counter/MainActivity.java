package com.rsiyun.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hasil;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void load(){
        hasil = findViewById(R.id.tvHasil);
    }
    public void btnUP(View view) {
        count++;
        hasil.setText(count+"");
    }

    public void btnDown(View view) {
        count--;
        hasil.setText(count+"");
    }
}