package uas_pemrograman2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_pelanggan";
                String user = "root";
                String pass = "";
                koneksi = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return koneksi;
    }
}
