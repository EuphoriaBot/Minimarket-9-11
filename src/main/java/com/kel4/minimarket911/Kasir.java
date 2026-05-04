package com.kel4.minimarket911;

public class Kasir extends Karyawan {

    public Kasir() {}

    public Kasir(String id, String nama, String telepon, double gajiMurni, String shift) {
        super(id, nama, telepon, "Kasir", gajiMurni, shift);
    }

    @Override
    public double hitungGaji() {
        return getGajiMurni();
    }

    @Override
    public String getRingkasan() {
        return getNama() + "Kasir, Shift: " + getShift() + "Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}
