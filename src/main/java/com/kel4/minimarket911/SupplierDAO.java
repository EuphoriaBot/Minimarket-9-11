package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;

public class SupplierDAO {

    public ArrayList<Supplier> getAllSupplier() {
        ArrayList<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM tbsupplier ORDER BY nama_perusahaan";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(mapSupplier(rs));
        } catch (SQLException e) {
            System.out.println("Error getAllSupplier: " + e.getMessage());
        }
        return list;
    }

    public Supplier getSupplierById(String id) {
        String sql = "SELECT * FROM tbsupplier WHERE id_supplier = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapSupplier(rs);
        } catch (SQLException e) {
            System.out.println("Error getSupplierById: " + e.getMessage());
        }
        return null;
    }

    public boolean tambahSupplier(Supplier s) {
        String sql = "INSERT INTO tbsupplier VALUES (?,?,?,?,?)";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.setString(2, s.getNama());
            ps.setString(3, s.getTelepon());
            ps.setString(4, s.getNamaPerusahaan());
            ps.setString(5, s.getKota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error tambahSupplier: " + e.getMessage());
            return false;
        }
    }

    public boolean updateSupplier(Supplier s) {
        String sql = "UPDATE tbsupplier SET nama_supplier=?, telepon_supplier=?, " + "nama_perusahaan=?, kota_supplier=? WHERE id_supplier=?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getNama());
            ps.setString(2, s.getTelepon());
            ps.setString(3, s.getNamaPerusahaan());
            ps.setString(4, s.getKota());
            ps.setString(5, s.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateSupplier: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusSupplier(String id) {
        String sql = "DELETE FROM tbsupplier WHERE id_supplier = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapusSupplier: " + e.getMessage());
            return false;
        }
    }

    private Supplier mapSupplier(ResultSet rs) throws SQLException {
        Supplier s = new Supplier();
        s.setId(rs.getString("id_supplier"));
        s.setNama(rs.getString("nama_supplier"));
        s.setTelepon(rs.getString("telepon_supplier"));
        s.setNamaPerusahaan(rs.getString("nama_perusahaan"));
        s.setKota(rs.getString("kota_supplier"));
        return s;
    }
}
