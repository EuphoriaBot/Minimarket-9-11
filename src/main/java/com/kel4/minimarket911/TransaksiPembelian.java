package com.kel4.minimarket911;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransaksiPembelian {
    private String idPembelian;
    private LocalDate tanggal;
    private Supplier supplier;
    private ArrayList<ItemPembelian> items;
    private double totalHarga;

    public TransaksiPembelian(String idPembelian, Supplier supplier) {
        this.idPembelian = idPembelian;
        this.supplier = supplier;
        this.tanggal = LocalDate.now();
        this.items = new ArrayList<>();
    }

    public void tambahItem(Produk produk, int kuantitas, double hargaBeli) {
        items.add(new ItemPembelian(produk, kuantitas, hargaBeli));
        hitungTotal();
    }

    private void hitungTotal() {
        totalHarga = 0;
        for (ItemPembelian item : items) {
            totalHarga += item.getSubtotal();
        }
    }

    public String getIdPembelian() {
        return idPembelian;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public ArrayList<ItemPembelian> getItems() {
        return items;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}
