package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProdukDAO {

    public ArrayList<Produk> getAllProduk() {
        ArrayList<Produk> list = new ArrayList<>();
        String sql = "SELECT p.*, k.nama_kategori, k.deskripsi_kategori " +
                "FROM tbproduk p LEFT JOIN tbkategori k ON p.id_kategori = k.id_kategori " +
                "ORDER BY p.nama_produk";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(mapProduk(rs));
        } catch (SQLException e) {
            System.out.println("Error getAllProduk: " + e.getMessage());
        }
        return list;
    }

    public HashMap<String, Produk> getProdukMap() {
        HashMap<String, Produk> map = new HashMap<>();
        for (Produk p : getAllProduk()) {
            map.put(p.getKode(), p);
        }
        return map;
    }

    public Produk getProdukById(String id) {
        String sql = "SELECT p.*, k.nama_kategori, k.deskripsi_kategori " +
                "FROM tbproduk p LEFT JOIN tbkategori k ON p.id_kategori = k.id_kategori " +
                "WHERE p.id_produk = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapProduk(rs);
        } catch (SQLException e) {
            System.out.println("Error getProdukById: " + e.getMessage());
        }
        return null;
    }

    public boolean tambahProduk(Produk p) {
        String sql = "INSERT INTO tbproduk VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getKategori().getId());
            ps.setDouble(4, p.getHargaBeli());
            ps.setDouble(5, p.getHargaJual());
            ps.setInt(6, p.getStok());
            ps.setInt(7, p.getStokMinimum());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error tambahProduk: " + e.getMessage());
            return false;
        }
    }

    public boolean updateProduk(Produk p) {
        String sql = "UPDATE tbproduk SET nama_produk=?, id_kategori=?, harga_beli=?, " +
                "harga_jual=?, stok_produk=?, stok_minimum=? WHERE id_produk=?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getKategori().getId());
            ps.setDouble(3, p.getHargaBeli());
            ps.setDouble(4, p.getHargaJual());
            ps.setInt(5, p.getStok());
            ps.setInt(6, p.getStokMinimum());
            ps.setString(7, p.getKode());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateProduk: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusProduk(String id) {
        String sql = "DELETE FROM tbproduk WHERE id_produk = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapusProduk: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStok(String idProduk, int jumlah) {
        String sql = "UPDATE tbproduk SET stok_produk = stok_produk + ? WHERE id_produk = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, jumlah);
            ps.setString(2, idProduk);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateStok: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Produk> getProdukStokMenunipis() {
        ArrayList<Produk> list = new ArrayList<>();
        String sql = "SELECT p.*, k.nama_kategori, k.deskripsi_kategori " +
                "FROM tbproduk p LEFT JOIN tbkategori k ON p.id_kategori = k.id_kategori " +
                "WHERE p.stok_produk <= p.stok_minimum";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(mapProduk(rs));
        } catch (SQLException e) {
            System.out.println("Error getProdukStokMenunipis: " + e.getMessage());
        }
        return list;
    }

    private Produk mapProduk(ResultSet rs) throws SQLException {
        Kategori kat = new Kategori();
        kat.setId(rs.getString("id_kategori"));
        kat.setNama(rs.getString("nama_kategori"));
        kat.setDeskripsi(rs.getString("deskripsi_kategori"));

        Produk p = new Produk();
        p.setKode(rs.getString("id_produk"));
        p.setNama(rs.getString("nama_produk"));
        p.setKategori(kat);
        p.setHargaBeli(rs.getDouble("harga_beli"));
        p.setHargaJual(rs.getDouble("harga_jual"));
        p.setStok(rs.getInt("stok_produk"));
        p.setStokMinimum(rs.getInt("stok_minimum"));
        return p;
    }
}