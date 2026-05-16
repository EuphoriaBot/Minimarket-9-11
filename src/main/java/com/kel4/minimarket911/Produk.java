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

    public String getNama() {
        return nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public int getStokMinimum() {
        return stokMinimum;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setHargaBeli(double hargaBeli) {
        if (hargaBeli < 0) {
            System.out.println("Harga beli tidak boleh negatif");
            return;
        }
        this.hargaBeli = hargaBeli;
    }
    public void setHargaJual(double hargaJual) {
        if (hargaJual < 0) {
            System.out.println("Harga jual tidak boleh negatif");
            return;
        }
        this.hargaJual = hargaJual;
    }
    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif");
            return;
        }
        this.stok = stok;
    }
    public void setStokMinimum(int stokMinimum) {
        this.stokMinimum = stokMinimum;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > stok) {
            System.out.println("Stok tidak mencukupi");
            return;
        }
        this.stok -= jumlah;
    }

    public String getStatusStok() {
        if (stok == 0) return "Habis";
        if (stok <= stokMinimum) return "Menipis";
        return "Aman";
    }

    @Override
    public String toString() { return kode + " - " + nama; }
}