package com.rsiyun.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }
    public void showAlert(String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERHATIAN");
        buatAlert.setMessage(pesan);
        buatAlert.show();
    }

    public void showAlertButton(String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERINGATAN!");
        buatAlert.setMessage(pesan);
        buatAlert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("data sudah di hapus");
            }
        });
        buatAlert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data tidak jadi dihapus");
            }
        });
        buatAlert.show();
    }

    public void btnToast(View view) {
        showToast("Belajar Toast");
    }

    public void btnAlert(View view) {
        showAlert("Selamat Belajar");
    }

    public void btnAlertDialogButton(View view) {
        showAlertButton("Apakah anda yakin ingin menghapus data anda");
    }
}