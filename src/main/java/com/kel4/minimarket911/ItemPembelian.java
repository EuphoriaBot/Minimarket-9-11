package com.kel4.minimarket911;

public class ItemPembelian {
    private Produk produk;
    private int kuantitas;
    private double hargaBeli;

    public ItemPembelian(Produk produk, int kuantitas, double hargaBeli) {
        this.produk = produk;
        this.kuantitas = kuantitas;
        this.hargaBeli = hargaBeli;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public double getSubtotal() {
        return hargaBeli * kuantitas;
    }
}
