package com.kel4.minimarket911;

public class DiskonMember implements Diskon {
    private Pelanggan pelanggan;

    public DiskonMember(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    @Override
    public double hitungDiskon(double totalBelanja) {
        switch (pelanggan.getLevel()) {
            case "Gold":   return totalBelanja * 0.10;
            case "Silver": return totalBelanja * 0.05;
            default:       return 0;
        }
    }

    @Override
    public String getNamaDiskon() {
        return "Diskon Member " + pelanggan.getLevel();
    }
}
