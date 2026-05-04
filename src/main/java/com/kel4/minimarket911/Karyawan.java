package com.kel4.minimarket911;

public abstract class Karyawan extends Person {
    private String jabatan;
    private double gajiMurni;
    private String shift;

    public Karyawan () {}

    public Karyawan(String id, String nama, String telepon, String jabatan, double gajiMurni, String shift){
        this.jabatan = jabatan;
        this.gajiMurni = gajiMurni;
        this.shift = shift;
    }

    public String getJabatan() {
        return jabatan;
    }

    public boolean setJabatan(String jabatan) {
        if (jabatan == null || jabatan.trim().isEmpty()) {
            System.out.println("Gopnik Bear");
            return false;
        }
        this.jabatan = jabatan;
        return true;
    }

    public double getGajiMurni() {
        return gajiMurni;
    }

    public boolean setGajiMurni(double gajiMurni) {
        if (gajiMurni < 0) {
            System.out.println("Gaji tidak boleh negatif");
            return false;
        }
        this.gajiMurni = gajiMurni;
        return true;
    }

    public String getShift() {
        return shift;
    }

    public boolean setShift(String shift) {
        if (shift == null || shift.trim().isEmpty()) {
            System.out.println("Shift tidak boleh kosong");
            return false;
        }
        this.shift = shift;
        return true;
    }

    public abstract double hitungGaji();

    @Override
    public String getRingkasan() {
        return getNama() + " | " + jabatan + " | Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}
