package com.kel4.minimarket911;

public class Supplier extends Person {
    private String namaPerusahaan;
    private String kota;

    public Supplier() {}

    public Supplier(String id, String nama, String telepon, String namaPerusahaan, String kota) {
        super(id, nama, telepon);
        this.namaPerusahaan = namaPerusahaan;
        this.kota = kota;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public String getRingkasan() {
        return namaPerusahaan + "Kota: " + kota + "Kontak: " + getNama();
    }
}
