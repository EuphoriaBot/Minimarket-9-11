package com.kel4.minimarket911;

public class Manager extends Karyawan {
    private double bonus;

    public Manager() {}

    public Manager(String id, String nama, String telepon, double gajiBasis, double bonus) {
        super(id, nama, telepon, "Manager", gajiBasis, "-");
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double hitungGaji() {
        return getGajiBasis() + bonus;
    }

    @Override
    public String getRingkasan() {
        return getNama() + " | Manager | Bonus: Rp " + String.format("%,.0f", bonus) + " | Total Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}