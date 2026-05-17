package com.kel4.minimarket911;

import java.sql.*;
import java.util.ArrayList;

public class KaryawanDAO {

    public ArrayList<Karyawan> getAllKaryawan() {
        ArrayList<Karyawan> list = new ArrayList<>();
        String sql = "SELECT * FROM tbkaryawan ORDER BY nama_karyawan";
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(mapKaryawan(rs));
        } catch (SQLException e) {
            System.out.println("Error getAllKaryawan: " + e.getMessage());
        }
        return list;
    }

    public Karyawan getKaryawanById(String id) {
        String sql = "SELECT * FROM tbkaryawan WHERE id_karyawan = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapKaryawan(rs);
        } catch (SQLException e) {
            System.out.println("Error getKaryawanById: " + e.getMessage());
        }
        return null;
    }

    public boolean tambahKaryawan(Karyawan k) {
        String sql = "INSERT INTO tbkaryawan VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getId());
            ps.setString(2, k.getNama());
            ps.setString(3, k.getTelepon());
            ps.setString(4, k.getJabatan());
            ps.setDouble(5, k.getGajiBasis());
            ps.setString(6, k.getShift());
            ps.setDouble(7, k instanceof Manager ? ((Manager) k).getBonus() : 0);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error tambahKaryawan: " + e.getMessage());
            return false;
        }
    }

    public boolean updateKaryawan(Karyawan k) {
        String sql = "UPDATE tbkaryawan SET nama_karyawan=?, telepon_karyawan=?, " + "jabatan=?, gaji_murni=?, shift=?, bonus=? WHERE id_karyawan=?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, k.getNama());
            ps.setString(2, k.getTelepon());
            ps.setString(3, k.getJabatan());
            ps.setDouble(4, k.getGajiBasis());
            ps.setString(5, k.getShift());
            ps.setDouble(6, k instanceof Manager ? ((Manager) k).getBonus() : 0);
            ps.setString(7, k.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateKaryawan: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusKaryawan(String id) {
        String sql = "DELETE FROM tbkaryawan WHERE id_karyawan = ?";
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapusKaryawan: " + e.getMessage());
            return false;
        }
    }

    private Karyawan mapKaryawan(ResultSet rs) throws SQLException {
        String jabatan = rs.getString("jabatan");
        if (jabatan.equals("Manager")) {
            Manager m = new Manager();
            m.setId(rs.getString("id_karyawan"));
            m.setNama(rs.getString("nama_karyawan"));
            m.setTelepon(rs.getString("telepon_karyawan"));
            m.setJabatan("Manager");
            m.setGajiBasis(rs.getDouble("gaji_murni"));
            m.setShift(rs.getString("shift"));
            m.setBonus(rs.getDouble("bonus"));
            return m;
        } else {
            Kasir k = new Kasir();
            k.setId(rs.getString("id_karyawan"));
            k.setNama(rs.getString("nama_karyawan"));
            k.setTelepon(rs.getString("telepon_karyawan"));
            k.setJabatan("Kasir");
            k.setGajiBasis(rs.getDouble("gaji_murni"));
            k.setShift(rs.getString("shift"));
            return k;
        }
    }
}