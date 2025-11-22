package minggu6.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static final String DATABASE = "modul4";
    public static final String PORT = "3306";
    public static final String HOST = "127.0.0.1";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
