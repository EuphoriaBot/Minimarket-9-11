package com.kel4.minimarket911;

public class PembayaranTunai extends Pembayaran {
    private double uangDiberikan;
    private double kembalian;

    public PembayaranTunai(double totalTagihan) {
        super(totalTagihan);
    }

    public double getUangDiberikan() {
        return uangDiberikan;
    }

    public void setUangDiberikan(double uangDiberikan) {
        this.uangDiberikan = uangDiberikan;
    }

    public double getKembalian() {
        return kembalian;
    }

    public double hitungKembalian() {
        return uangDiberikan - totalTagihan;
    }

    @Override
    public boolean proses(double nominal) {
        if (nominal < totalTagihan) return false;
        this.uangDiberikan = nominal;
        this.jumlahBayar = nominal;
        this.kembalian = hitungKembalian();
        return true;
    }

    @Override
    public String getMetode() { return "Tunai"; }

    @Override
    public String getDetailPembayaran() {
        return "Tunai, Total: Rp " +
                String.format("%,.0f", totalTagihan) +
                "Dibayar: Rp " +
                String.format("%,.0f", uangDiberikan) +
                "Kembalian: Rp " +
                String.format("%,.0f", kembalian);
    }
}
