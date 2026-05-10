package com.kel4.minimarket911;

public class DiskonPromo implements Diskon {
    private double persen;
    private String namaPromo;

    public DiskonPromo(String namaPromo, double persen) {
        this.namaPromo = namaPromo;
        this.persen = persen;
    }

    public double getPersen() {
        return persen;
    }

    public void setPersen(double persen) {
        this.persen = persen;
    }

    @Override
    public double hitungDiskon(double totalBelanja) {
        return totalBelanja * (persen / 100);
    }

    @Override
    public String getNamaDiskon() {
        return "Promo " + namaPromo + " (" + (int)persen + "%)";
    }
}
