package com.kel4.minimarket911;

public abstract class Pembayaran {
    protected double jumlahBayar;
    protected double totalTagihan;

    public Pembayaran() {}

    public Pembayaran(double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public double getJumlahBayar() {
        return jumlahBayar;
    }

    public double getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public abstract boolean proses(double nominal);

    public abstract String getMetode();

    public abstract String getDetailPembayaran(); // tetap dipertahankan dari punya kamu
}
