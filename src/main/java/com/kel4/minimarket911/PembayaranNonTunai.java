package com.kel4.minimarket911;

public class PembayaranNonTunai extends Pembayaran {
    private String nomorReferensi;

    public PembayaranNonTunai(double totalTagihan, String nomorReferensi) {
        super(totalTagihan);
        this.nomorReferensi = nomorReferensi;
    }

    public String getNomorReferensi() {
        return nomorReferensi;
    }

    public void setNomorReferensi(String nomorReferensi) {
        this.nomorReferensi = nomorReferensi;
    }

    @Override
    public boolean proses(double nominal) {
        this.jumlahBayar = totalTagihan;
        return true;
    }

    @Override
    public String getMetode() {
        return "Non-Tunai";
    }

    @Override
    public String getDetailPembayaran() {
        return "Non Tunai, Total: Rp " + String.format("%,.0f", totalTagihan) + "Ref: " + nomorReferensi;
    }
}