import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/uas_pemrograman2";
                String user = "root";
                String pass = "";

                koneksi = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
