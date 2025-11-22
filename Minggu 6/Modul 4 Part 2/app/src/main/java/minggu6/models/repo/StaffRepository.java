package minggu6.models.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import minggu6.util.connection;

public class StaffRepository {
private static Connection conn;

    static {
        conn = connection.getConnection();
    }
    public void printGajiStaff(String nik) {
        String sql = "SELECT * FROM staff WHERE user_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nik);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Data Staff dengan NIK " + nik + " tidak ditemukan.");
            } else {
                String status = rs.getString("user_type");

                if (status.equalsIgnoreCase(status)) {
                    
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
