package minggu6.models.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import minggu6.models.DosenHonorer;
import minggu6.models.DosenTetap;
import minggu6.models.Karyawan;
import minggu6.models.Mahasiswa;
import minggu6.models.User;
import minggu6.util.connection;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();
    private static Connection conn;

    static {
        conn = connection.getConnection();;
    }

    public ArrayList<User> printMahasiswaByName(String name) {
        String sql = "SELECT * FROM user WHERE nama LIKE = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("nama");
                String tempatLahir = rs.getString("tempat_lahir");
                String tanggalLahir = rs.getString("tanggal_lahir");
                String alamat = rs.getString("alamat");
                String telepon = rs.getString("telepon");
                String userType = rs.getString("user_type");
                String nomorInduk = rs.getString("user_id");

                if (userType.equals("MAHASISWA")) { // New Mahasiswa

                    // Override the prepared statement and to get kodeJurusan
                    String sql2 = "SELECT kode_jurusan FROM mahasiswa WHERE nim = ?";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, nomorInduk);

                    // Get the result set for kodeJurusan
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        String kodeJurusan = rs2.getString("kode_jurusan");
                        users.add(new Mahasiswa(nomorInduk, nama, tempatLahir, tanggalLahir, alamat, telepon, kodeJurusan));

                    } else {
                        System.out.println("Data mahasiswa dengan NIM " + nomorInduk + " tidak ditemukan.");
                    }
                } else if (userType.equals("DOSEN_TETAP")) { // New Dosen Tetap
                    String sql2 = "SELECT d.*, dt.salary FROM dosen d INNER JOIN dosen_tetap dt ON d.nik = dt.nik WHERE d.nik = ? ";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, nomorInduk);

                    //Result Set
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        double salary = rs2.getDouble("salary");
                        String depart = rs2.getString("departemen");
                        users.add(new DosenTetap(nomorInduk, nama, tempatLahir, tanggalLahir, alamat, telepon, depart, salary));
                    } else {
                        System.out.println("Data dosen tetap dengan NIK " + nomorInduk + " tidak ditemukan.");
                    }

                } else if (userType.equals("DOSEN_HONORER")) { // New Dosen Honorer
                    String sql2 = "SELECT d.*, dh.honor_per_sks FROM dosen d INNER JOIN dosen_honorer dh ON d.nik = dh.nik WHERE d.nik = ? ";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, nomorInduk);

                    //Result Set
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        double salary = rs2.getDouble("honor_per_sks");
                        String depart = rs2.getString("departemen");
                        users.add(new DosenHonorer(nomorInduk, nama, tempatLahir, tanggalLahir, alamat, telepon, depart, salary));
                    } else {
                        System.out.println("Data dosen honorer dengan NIK " + nomorInduk + " tidak ditemukan.");
                    }

                } else { // New Karyawan
                    String sql2 = "SELECT * FROM karyawan d WHERE d.nik = ? ";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, nomorInduk);

                    //Result Set
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        double salary = rs2.getDouble("salary");
                        users.add(new Karyawan(nomorInduk, nama, tempatLahir, tanggalLahir, alamat, telepon, salary));
                    } else {
                        System.out.println("Data karyawan dengan NIK " + nomorInduk + " tidak ditemukan.");
                    }

                }

                // Ini Ngeprint data user yang ditemukan
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
