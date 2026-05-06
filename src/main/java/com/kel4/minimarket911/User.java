package com.kel4.minimarket911;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String idKaryawan;

    public User() {}

    public User(int id, String username, String password, String role, String idKaryawan) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idKaryawan = idKaryawan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }
}