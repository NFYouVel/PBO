package minggu6.models.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import minggu6.models.Dosen;
import minggu6.util.connection;

public class DosenRepository {
    private ArrayList<Dosen> dosen = new ArrayList<>();
    private static Connection conn;

    static {
        conn = connection.getConnection();
    }

    public void getPrintTotalJamMengajarDosen(String nik){
        String sql = "SELECT * FROM matkul_ajar ma INNER JOIN presensi_staff ps ON ma.matkul_ajar_id = ps.matkul_ajar_id WHERE ma.nik = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nik);
            ResultSet rs = ps.executeQuery();

            int temp_jam = 0;
            while (rs.next()) {
                int jumlahJam = rs.getInt("jam");
                int status = rs.getInt("status");

                if (status == 1) {
                    temp_jam += jumlahJam;
                }
            }

            System.out.println("Total Jam Mengajar Dosen dengan NIK " + nik + " adalah: " + temp_jam);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
