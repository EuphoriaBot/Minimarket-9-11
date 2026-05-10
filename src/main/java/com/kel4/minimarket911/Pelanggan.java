package com.kel4.minimarket911;

public class Pelanggan extends Person {
    private int poin;
    private double totalBelanja;
    private String level;

    public Pelanggan() {}

    public Pelanggan(String id, String nama, String telepon) {
        super(id, nama, telepon);
        this.poin = 0;
        this.totalBelanja = 0;
        this.level = "Level 1 Crook";
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public double getTotalBelanja() {
        return totalBelanja;
    }

    public void setTotalBelanja(double totalBelanja) {
        this.totalBelanja = totalBelanja;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void tambahBelanja(double jumlah) {
        this.totalBelanja += jumlah;
        this.poin += (int)(jumlah / 10000);
        updateLevel();
    }

    private void updateLevel() {
        if (totalBelanja >= 2000000) {
            level = "Gold";
        } else if (totalBelanja >= 500000) {
            level = "Silver";
        } else {
            level = "Reguler";
        }
    }

    @Override
    public String getRingkasan() {
        return getNama() + "Level: " + level + "Poin: " + poin + "Total Belanja: Rp " + String.format("%,.0f", totalBelanja);
    }
}
