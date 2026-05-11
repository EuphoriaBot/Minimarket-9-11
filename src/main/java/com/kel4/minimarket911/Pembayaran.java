package com.kel4.minimarket911;

public class Pembayaran {
    private double totalTagihan;
    private double uangDiberikan;
    private double kembalian;

    public Pembayaran(double totalTagihan, double uangDiberikan) {
        this.totalTagihan = totalTagihan;
        this.uangDiberikan = uangDiberikan;
        this.kembalian = uangDiberikan - totalTagihan;
    }

    public double getTotalTagihan() {
        return totalTagihan;
    }

    public double getUangDiberikan() {
        return uangDiberikan;
    }

    public double getKembalian() {
        return kembalian;
    }

    public boolean isValid() {
        return uangDiberikan >= totalTagihan;
    }

    public String getDetailPembayaran() {
        return "Tunai | Total: Rp " + String.format("%,.0f", totalTagihan) + " | Dibayar: Rp " + String.format("%,.0f", uangDiberikan) + " | Kembalian: Rp " + String.format("%,.0f", kembalian);
    }
}
