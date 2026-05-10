package com.kel4.minimarket911;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private LocalDateTime waktu;
    private Kasir kasir;
    private Pelanggan pelanggan;
    private ArrayList<ItemBelanja> items;
    private Diskon diskon;
    private Pembayaran pembayaran;
    private double totalSebelumDiskon;
    private double totalDiskon;
    private double totalAkhir;


    public Transaksi(String idTransaksi, Kasir kasir, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.kasir = kasir;
        this.pelanggan = pelanggan;
        this.waktu = LocalDateTime.now();
        this.items = new ArrayList<>();
    }


    public void tambahItem(Produk produk, int kuantitas) {
        for (ItemBelanja item : items) {
            if (item.getProduk().getKode().equals(produk.getKode())) {
                item.setKuantitas(item.getKuantitas() + kuantitas);
                hitungTotal();
                return;
            }
        }
        items.add(new ItemBelanja(produk, kuantitas));
        hitungTotal();
    }

    public void hapusItem(int index) {
        items.remove(index);
        hitungTotal();
    }

    private void hitungTotal() {
        totalSebelumDiskon = 0;
        for (ItemBelanja item : items) {
            totalSebelumDiskon += item.getSubtotal();
        }
        if (diskon != null) {
            totalDiskon = diskon.hitungDiskon(totalSebelumDiskon);
        } else {
            totalDiskon = 0;
        }
        totalAkhir = totalSebelumDiskon - totalDiskon;
    }

    public void setDiskon(Diskon diskon) {
        this.diskon = diskon;
        hitungTotal();
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public ArrayList<ItemBelanja> getItems() {
        return items;
    }

    public Diskon getDiskon() {
        return diskon;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public double getTotalSebelumDiskon() {
        return totalSebelumDiskon;
    }

    public double getTotalDiskon() {
        return totalDiskon;
    }

    public double getTotalAkhir() {
        return totalAkhir;
    }

    public String getWaktuFormatted() {
        return waktu.toString();
    }
}