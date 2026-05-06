package com.kel4.minimarket911;

public class Produk {
    private String kode;
    private String nama;
    private Kategori kategori;
    private double hargaBeli;
    private double hargaJual;
    private int stok;
    private int stokMinimum;

    public Produk() {}

    public Produk(String kode, String nama, Kategori kategori, double hargaBeli, double hargaJual, int stok, int stokMinimum) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stok = stok;
        this.stokMinimum = stokMinimum;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        if (hargaBeli < 0) {
            System.out.println("Harga jangan negatif");
            return;
        }
        this.hargaBeli = hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        if (hargaJual < 0) {
            System.out.println("Harga jgn negatif");
            return;
        }
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok jgn mines");
            return;
        }
        this.stok = stok;
    }

    public int getStokMinimum() {
        return stokMinimum;
    }

    public void setStokMinimum(int stokMinimum) {
        this.stokMinimum = stokMinimum;
    }

    public void tambahStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("jml hrs lbh dr 0");
            return;
        }
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > stok) {
            System.out.println("Stok tdk ckp");
            return;
        }
        this.stok -= jumlah;
    }

    public String getStatusStok() {
        if (stok == 0) {
            return "Habis Bosss";
        } else if (stok <= stokMinimum) {
            return "Mulai Menipis Boss";
        } else {
            return "Aman Boss";
        }
    }

    @Override
    public String toString() { return kode + " " + nama; }
}
