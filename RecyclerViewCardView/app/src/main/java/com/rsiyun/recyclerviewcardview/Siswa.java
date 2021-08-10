package com.rsiyun.recyclerviewcardview;

public class Siswa {
    private String nama;
    private String alamat;

    //Constructor
    public Siswa(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    //Getter and Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
