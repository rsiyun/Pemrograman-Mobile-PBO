package com.rsiyun.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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

    String idbarang;
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
                String sql = "UPDATE tblbarang SET barang = '"+barang+"',  stok = "+stock+", harga="+harga+" WHERE idbarang = "+idbarang+";";
                if (db.runSQL(sql)){
                    pesan("Update Berhasil");
                    selectData();
                }else{
                    pesan("Update Berhasil");
                }
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
        idbarang = id;
        String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+";";
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("PERINGATAN !!");
        al.setMessage("Apakah anda yakin Ingin Menghapus data Tersebut !");
        al.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (db.runSQL(sql)){
                    pesan("Delete Berhasil");
                    selectData();
                }else{
                    pesan("Delete Gagal");
                }
            }
        });
        al.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        al.show();
    }
    public void selectUpdate(String id){
        idbarang = id;
        String sql="SELECT * FROM tblbarang WHERE idbarang ="+id+";";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();
        etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etStock.setText(cursor.getString(cursor.getColumnIndex("stok")));
        etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));
        tvPilihan.setText("update");

    }
}