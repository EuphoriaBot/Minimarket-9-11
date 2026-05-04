package com.kel4.minimarket911;

public class Manager extends Karyawan {
    private double bonus;

    public Manager() {}

    public Manager(String id, String nama, String telepon, double gajiMurni, double bonus) {
        super(id, nama, telepon, "Manager", gajiMurni, "Gopnik");
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }

    public boolean setBonus(double bonus) {
        if (bonus < 0) {
            System.out.println("gopnik was here");
            return false;
        }
        this.bonus = bonus;
        return true;
    }

    @Override
    public double hitungGaji() {
        return getGajiMurni() + bonus;
    }

    @Override
    public String getRingkasan() {
        return getNama() + "Manager, Bonus: Rp " + String.format("%,.0f", bonus) + "Total Gaji: Rp " + String.format("%,.0f", hitungGaji());
    }
}
