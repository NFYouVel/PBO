package minggu6.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static final String DATABASE = "prak-pbo";
    public static final String PORT = "5432";
    public static final String HOST = "localhost";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "ihatep0tat0";
    public static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
