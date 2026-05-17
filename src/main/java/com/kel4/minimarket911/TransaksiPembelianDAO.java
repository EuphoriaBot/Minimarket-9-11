package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;

public class TransaksiPembelianDAO {

    public boolean simpanPembelian(TransaksiPembelian t) {
        Connection conn = Koneksi.getConnection();
        try {
            conn.setAutoCommit(false);

            String sqlHeader = "INSERT INTO tbtransaksi_pembelian VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sqlHeader);
            ps.setString(1, t.getIdPembelian());
            ps.setDate(2, Date.valueOf(t.getTanggal()));
            ps.setString(3, t.getSupplier().getId());
            ps.setDouble(4, t.getTotalHarga());
            ps.executeUpdate();

            String sqlDetail = "INSERT INTO tbdetail_transaksi_pembelian VALUES (?,?,?,?,?,?)";
            PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
            int no = 1;
            for (ItemPembelian item : t.getItems()) {
                psDetail.setString(1, "DP-" + t.getIdPembelian() + "-" + no);
                psDetail.setString(2, t.getIdPembelian());
                psDetail.setString(3, item.getProduk().getKode());
                psDetail.setInt(4, item.getKuantitas());
                psDetail.setDouble(5, item.getHargaBeli());
                psDetail.setDouble(6, item.getSubtotal());
                psDetail.executeUpdate();

                String sqlStok = "UPDATE tbproduk SET stok_produk = stok_produk + ? WHERE id_produk = ?";
                PreparedStatement psStok = conn.prepareStatement(sqlStok);
                psStok.setInt(1, item.getKuantitas());
                psStok.setString(2, item.getProduk().getKode());
                psStok.executeUpdate();

                no++;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Error simpanPembelian: " + e.getMessage());
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public ArrayList<String[]> getRiwayatPembelian() {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT tp.*, s.nama_perusahaan FROM tbtransaksi_pembelian tp " + "JOIN tbsupplier s ON tp.id_supplier = s.id_supplier " + "ORDER BY tp.tanggal_pembelian DESC";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("id_pembelian"),
                        rs.getString("tanggal_pembelian"),
                        rs.getString("nama_perusahaan"),
                        String.valueOf(rs.getDouble("total_harga_pembelian"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Error getRiwayatPembelian: " + e.getMessage());
        }
        return list;
    }
}