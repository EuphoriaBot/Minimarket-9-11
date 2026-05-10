package com.kel4.minimarket911;

public class ItemBelanja {
    private Produk produk;
    private int kuantitas;

    public ItemBelanja(Produk produk, int kuantitas) {
        this.produk = produk;
        this.kuantitas = kuantitas;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getKuantitas() {
        return kuantitas;

    }
    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public double getSubtotal() {
        return produk.getHargaJual() * kuantitas;
    }
}
