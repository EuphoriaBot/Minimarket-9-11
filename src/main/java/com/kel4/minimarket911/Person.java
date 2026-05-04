package com.kel4.minimarket911;

public abstract class  Person {
    private String id;
    private String nama;
    private String telepon;

    public Person() {}

    public Person(String id, String nama, String telepon) {
        this.id = id;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID tidak boleh kosong");
            return;
        }
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong");
            return;
        }
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public boolean setTelepon(String telepon) {
        this.telepon = telepon;
        return true;
    }

    public abstract String getRingkasan();

    @Override
    public String toString() {
        return nama + "(" + id + ")";
    }
}
