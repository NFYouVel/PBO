package pertemuan2.repository;

// Library
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// Object
import pertemuan2.DatabaseConnection;

public class EvaluateRepository {

    static Scanner sc = new Scanner(System.in);
    private static Connection conn;

    static {
        Connection temp = null;
        try {
            temp = DatabaseConnection.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn = temp;
    }

    public static double CountNilai(double nilai) {
        if (nilai >= 80) {
            return 4;
        } else if (nilai >= 76) {
            return 3.7;
        } else if (nilai >= 72) {
            return 3.4;
        } else if (nilai >= 68) {
            return 3;
        } else if (nilai >= 64) {
            return 2.7;
        } else if (nilai >= 60) {
            return 2.4;
        } else if (nilai >= 54) {
            return 2;
        } else if (nilai == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static String CountIP(String nim) {
    String sql = "SELECT * FROM score_mahasiswa AS sm " +
                 "JOIN matakuliah AS mk ON mk.kode = sm.id_matakuliah " +
                 "WHERE sm.id_mahasiswa = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nim);
        ResultSet rs = stmt.executeQuery();
        
        int total_sks = 0;
        double nilai = 0;
        boolean adaData = false;
        
        while (rs.next()) {
            adaData = true;
            int score_index = rs.getInt("score_index");
            int sks = rs.getInt("sks");
            double result_nilai = CountNilai(score_index); // <- kayaknya ini harus score_index, bukan nilai
            
            nilai = nilai + result_nilai * sks;
            total_sks = total_sks + sks;
        }
        
        if (!adaData) {
            return "NIM Tidak ditemukan!";
        }
        
        double total = nilai / total_sks;
        String hasil = String.format("%.2f", total);
        return "IP : " + hasil;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return "Cek IP gagal!";
    }
}

    public static String InputNilai(String nim, String matakuliah, int nilai) {
        if (nim.equalsIgnoreCase("") || matakuliah.equalsIgnoreCase("")) {
            return "NIM dan Mata Kuliah tidak boleh ada yang kosong!";
        }
        String sql_checkNim = "SELECT nim FROM mahasiswa WHERE nim = ?";
        String sql_checkMatkul = "SELECT kode FROM matakuliah WHERE kode = ?";
        try {
            // Check NIM
            PreparedStatement stmt_nim = conn.prepareStatement(sql_checkNim);
            stmt_nim.setString(1, nim);
            ResultSet rs_nim = stmt_nim.executeQuery();

            if (!rs_nim.next()) {
                return "NIM tidak ditemukan!";
            }

            // Check Mata Kuliah
            PreparedStatement stmt_matkul = conn.prepareStatement(sql_checkMatkul);
            stmt_matkul.setString(1, matakuliah);
            ResultSet rs_matkul = stmt_matkul.executeQuery();

            if (!rs_matkul.next()) {
                return "Mata Kuliah tidak ditemukan!";
            }

            String sql_insertScoreMahasiswa = "INSERT INTO score_mahasiswa (id_mahasiswa,id_matakuliah, score_index) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql_insertScoreMahasiswa);
            preparedStatement1.setString(1, nim);
            preparedStatement1.setString(2, matakuliah);
            preparedStatement1.setInt(3, nilai);
            preparedStatement1.executeUpdate();
            return "Input berhasil!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi error saat input!";
        }
    }
}
