package com.kel4.minimarket911;

public class Kasir extends Karyawan {

    public Kasir() {}

    public Kasir(String id, String nama, String telepon, double gajiBasis, String shift) {
        super(id, nama, telepon, "Kasir", gajiBasis, shift);
    }

    @Override
    public double hitungGaji() {
        return getGajiBasis();
    }

    @Override
    public String getRingkasan() {
        return getNama() + " | Kasir | Shift: " + getShift() + " | Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}