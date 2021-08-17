package com.rsiyun.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etBarang, etStock, etHarga;
    TextView tvPilihan;
    List<Barang> databarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        selectData();
    }
    public void load(){
        db = new Database(this);
        db.buatTable();
        etBarang = findViewById(R.id.etBarang);
        etStock = findViewById(R.id.etStock);
        etHarga = findViewById(R.id.etHarga);
        tvPilihan = findViewById(R.id.tvPilihan);
        rcvBarang = findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }

    public void simpan(View view) {
        // ambil semua load
        // buat kondisi jika kosong dan buat kondisi jika pilihan
        String barang = etBarang.getText().toString();
        String harga = etHarga.getText().toString();
        String stock = etStock.getText().toString();
        String pilihan = tvPilihan.getText().toString();


        if (barang.isEmpty()||harga.isEmpty()||stock.isEmpty()||pilihan.isEmpty()){
            pesan("Data tidak Boleh Kosong");
        }else{
            if (pilihan.equals("insert")){
                String sql = "INSERT INTO tblbarang (barang,stok,harga) VALUES ('"+barang+"',"+stock+","+harga+")";
                if (db.runSQL(sql)){
                    pesan("Insert Berhasil");
                    selectData();
                }else{
                    pesan("Insert Gagal");
                }
            }else {
                pesan("Update");
            }
        }
        etBarang.setText("");
        etStock.setText("");
        etHarga.setText("");
        tvPilihan.setText("insert");

    }
    public void pesan(String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }
    public void selectData(){
        String sql = "SELECT * FROM tblbarang ORDER BY barang ASC";
        Cursor cursor = db.select(sql);
        databarang.clear();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
                String barang = cursor.getString(cursor.getColumnIndex("barang"));
                String stok = cursor.getString(cursor.getColumnIndex("stok"));
                String harga = cursor.getString(cursor.getColumnIndex("harga"));

                databarang.add(new Barang(idbarang,barang,stok,harga));
            }
            adapter = new BarangAdapter(this,databarang);
            rcvBarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else{
            pesan("Data Masih Kosong");
        }

    }
    public void Delete (String id) {
        String idbarang = id;
        String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+";";
        if (db.runSQL(sql)){
            pesan("Delete Berhasil");
            selectData();
        }else{
            pesan("Delete Gagal");
        }
    }
}