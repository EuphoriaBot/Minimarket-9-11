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
        this.jabatan = jabatan;
        return true;
    }

    public double getGajiMurni() {
        return gajiMurni;
    }

    public void setGajiMurni(double gajiMurni) {
        if (gajiMurni < 0) {
            System.out.println("Gaji harus lebih dari 0");
            return;
        }
        this.gajiMurni = gajiMurni;
    }

    public String getShift() {
        return shift;
    }

    public boolean setShift(String shift) {
        this.shift = shift;
        return true;
    }

    public abstract double hitungGaji();

    @Override
    public String getRingkasan() {
        return getNama() + " " + jabatan + "Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}
