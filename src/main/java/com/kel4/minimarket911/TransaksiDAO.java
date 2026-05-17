package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TransaksiDAO {

    public boolean simpanTransaksi(Transaksi t) {
        Connection conn = Koneksi.getConnection();
        try {
            conn.setAutoCommit(false);

            String sqlHeader = "INSERT INTO tbtransaksi VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sqlHeader);
            ps.setString(1, t.getIdTransaksi());
            ps.setTimestamp(2, Timestamp.valueOf(t.getWaktu()));
            ps.setString(3, t.getKasir().getId());
            ps.setDouble(4, t.getTotalHarga());
            ps.setDouble(5, t.getPembayaran().getUangDiberikan());
            ps.setDouble(6, t.getPembayaran().getKembalian());
            ps.executeUpdate();

            String sqlDetail = "INSERT INTO tbdetail_transaksi VALUES (?,?,?,?,?,?)";
            PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
            int no = 1;
            for (ItemBelanja item : t.getDaftarItem()) {
                psDetail.setString(1, "DT-" + t.getIdTransaksi() + "-" + no);
                psDetail.setString(2, t.getIdTransaksi());
                psDetail.setString(3, item.getProduk().getKode());
                psDetail.setDouble(4, item.getProduk().getHargaJual());
                psDetail.setInt(5, item.getKuantitas());
                psDetail.setDouble(6, item.getSubtotal());
                psDetail.executeUpdate();

                String sqlStok = "UPDATE tbproduk SET stok_produk = stok_produk - ? WHERE id_produk = ?";
                PreparedStatement psStok = conn.prepareStatement(sqlStok);
                psStok.setInt(1, item.getKuantitas());
                psStok.setString(2, item.getProduk().getKode());
                psStok.executeUpdate();

                String sqlKeluar = "INSERT INTO tbstock_keluar VALUES (?,?,?,?,?,?,?)";
                PreparedStatement psKeluar = conn.prepareStatement(sqlKeluar);
                psKeluar.setString(1, "SK-" + t.getIdTransaksi() + "-" + no);
                psKeluar.setString(2, item.getProduk().getKode());
                psKeluar.setString(3, item.getProduk().getNama());
                psKeluar.setString(4, t.getIdTransaksi());
                psKeluar.setDate(5, Date.valueOf(t.getWaktu().toLocalDate()));
                psKeluar.setInt(6, item.getKuantitas());
                psKeluar.setString(7, "Penjualan");
                psKeluar.executeUpdate();

                no++;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Error simpanTransaksi: " + e.getMessage());
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public LinkedList<String[]> getRiwayatTransaksi(String tanggal) {
        LinkedList<String[]> list = new LinkedList<>();
        String sql = "SELECT t.*, k.nama_karyawan FROM tbtransaksi t " + "LEFT JOIN tbkaryawan k ON t.id_kasir = k.id_karyawan " + "WHERE DATE(t.waktu_transaksi) = ? ORDER BY t.waktu_transaksi DESC";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("id_transaksi"),
                        rs.getString("waktu_transaksi"),
                        rs.getString("nama_karyawan"),
                        String.valueOf(rs.getDouble("total_harga")),
                        String.valueOf(rs.getDouble("uang_diberikan")),
                        String.valueOf(rs.getDouble("kembalian"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Error getRiwayatTransaksi: " + e.getMessage());
        }
        return list;
    }

    public double getTotalPenjualanHari(String tanggal) {
        String sql = "SELECT IFNULL(SUM(total_harga),0) FROM tbtransaksi WHERE DATE(waktu_transaksi) = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Error getTotalPenjualan: " + e.getMessage());
        }
        return 0;
    }

    public int getJumlahTransaksiHari(String tanggal) {
        String sql = "SELECT COUNT(*) FROM tbtransaksi WHERE DATE(waktu_transaksi) = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error getJumlahTransaksi: " + e.getMessage());
        }
        return 0;
    }

    public ArrayList<String[]> getProdukTerlaris(String tanggal) {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT dt.id_produk, p.nama_produk, " + "SUM(dt.kuantitas) as total_qty, " + "SUM(dt.subtotal_transaksi) as total_rev " + "FROM tbdetail_transaksi dt " + "JOIN tbtransaksi t ON dt.id_transaksi = t.id_transaksi " + "JOIN tbproduk p ON dt.id_produk = p.id_produk " + "WHERE DATE(t.waktu_transaksi) = ? " + "GROUP BY dt.id_produk, p.nama_produk " + "ORDER BY total_qty DESC LIMIT 10";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tanggal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("nama_produk"),
                        String.valueOf(rs.getInt("total_qty")),
                        String.valueOf(rs.getDouble("total_rev"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Error getProdukTerlaris: " + e.getMessage());
        }
        return list;
    }
}