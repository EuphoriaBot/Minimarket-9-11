package com.kel4.minimarket911;

public abstract class Karyawan extends Person {
    private String jabatan;
    private double gajiBasis;
    private String shift;

    public Karyawan() {}

    public Karyawan(String id, String nama, String telepon, String jabatan, double gajiBasis, String shift) {
        super(id, nama, telepon);
        this.jabatan = jabatan;
        this.gajiBasis = gajiBasis;
        this.shift = shift;
    }

    public String getJabatan() {
        return jabatan;
    }

    public double getGajiBasis() {
        return gajiBasis;
    }

    public String getShift() {
        return shift;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setGajiBasis(double gajiBasis) {
        this.gajiBasis = gajiBasis;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public abstract double hitungGaji();

    @Override
    public String getRingkasan() {
        return getNama() + " | " + jabatan + " | Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}