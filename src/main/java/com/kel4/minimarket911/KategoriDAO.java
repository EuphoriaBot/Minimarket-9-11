package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;

public class KategoriDAO {

    public ArrayList<Kategori> getAllKategori() {
        ArrayList<Kategori> list = new ArrayList<>();
        String sql = "SELECT * FROM tbkategori ORDER BY nama_kategori";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Kategori k = new Kategori();
                k.setId(rs.getString("id_kategori"));
                k.setNama(rs.getString("nama_kategori"));
                k.setDeskripsi(rs.getString("deskripsi_kategori"));
                list.add(k);
            }
        } catch (SQLException e) {
            System.out.println("Error getAllKategori: " + e.getMessage());
        }
        return list;
    }

    public boolean tambahKategori(Kategori k) {
        String sql = "INSERT INTO tbkategori VALUES (?,?,?)";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getId());
            ps.setString(2, k.getNama());
            ps.setString(3, k.getDeskripsi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error tambahKategori: " + e.getMessage());
            return false;
        }
    }

    public boolean updateKategori(Kategori k) {
        String sql = "UPDATE tbkategori SET nama_kategori=?, deskripsi_kategori=? WHERE id_kategori=?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getNama());
            ps.setString(2, k.getDeskripsi());
            ps.setString(3, k.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateKategori: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusKategori(String id) {
        String sql = "DELETE FROM tbkategori WHERE id_kategori = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapusKategori: " + e.getMessage());
            return false;
        }
    }
}