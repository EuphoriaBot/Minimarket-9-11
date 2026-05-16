package com.kel4.minimarket911;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private LocalDateTime waktu;
    private Kasir kasir;
    private ArrayList<ItemBelanja> daftarItem;
    private PembayaranTunai pembayaran;
    private double totalHarga;

    public Transaksi() {
        this.daftarItem = new ArrayList<>();
        this.waktu = LocalDateTime.now();
    }

    public Transaksi(String idTransaksi, Kasir kasir) {
        this.idTransaksi = idTransaksi;
        this.kasir = kasir;
        this.waktu = LocalDateTime.now();
        this.daftarItem = new ArrayList<>();
    }

    public void tambahItem(Produk produk, int kuantitas) {
        for (ItemBelanja item : daftarItem) {
            if (item.getProduk().getKode().equals(produk.getKode())) {
                item.setKuantitas(item.getKuantitas() + kuantitas);
                hitungTotal();
                return;
            }
        }
        daftarItem.add(new ItemBelanja(produk, kuantitas));
        hitungTotal();
    }

    public void hapusItem(int index) {
        daftarItem.remove(index);
        hitungTotal();
    }

    private void hitungTotal() {
        totalHarga = 0;
        for (ItemBelanja item : daftarItem) {
            totalHarga += item.getSubtotal();
        }
    }

    public void setPembayaran(PembayaranTunai pembayaran) {
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

    public ArrayList<ItemBelanja> getDaftarItem() {
        return daftarItem;
    }

    public PembayaranTunai getPembayaran() {
        return pembayaran;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    public String getWaktuFormatted() {
        return waktu.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}