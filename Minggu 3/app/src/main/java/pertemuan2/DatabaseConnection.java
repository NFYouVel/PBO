package pertemuan2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
     // Konfigurasi database
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/prak_pbo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Berhasil terhubung ke database PostgreSQL!");
        } catch (SQLException e) {
            System.err.println("Gagal terhubung ke database. Cek konfigurasi dan status server.");
            e.printStackTrace(); 
        }
    }
}
