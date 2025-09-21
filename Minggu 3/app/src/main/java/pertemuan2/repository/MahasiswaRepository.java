package pertemuan2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory;

import pertemuan2.DatabaseConnection;

public class MahasiswaRepository {

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

    public static void ViewDetailtMahasiswa(String find_nim){
        String sql = "SELECT  m.nim, m.nama AS nama_mahasiswa, jmj.id_jurusan, j.nama AS nama_jurusan FROM mahasiswa AS m JOIN junction_mahasiswa_jurusan AS jmj ON jmj.id_mahasiswa = m.nim JOIN jurusan AS j ON jmj.id_jurusan = j.kode WHERE m.nim = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, find_nim);
            ResultSet result = stmt.executeQuery();

            System.out.println("===============================");
            while (result.next()) {
                String nim = result.getString("nim");
                String nama = result.getString("nama_mahasiswa");
                String jurusan = result.getString("nama_jurusan");

                System.out.println("Mahasiswa: " + nama + " (" + nim + ") --> Jurusan: " + jurusan);
            }
            System.out.println("===============================");
        } catch (SQLException e) {
            System.out.println("NIM Tidak ditemukan");
            e.printStackTrace();
        }
    }
    public static void ViewListMahasiswa(){
        String sql = "SELECT m.nim, m.nama, jmj.id_jurusan FROM mahasiswa AS m\r\n" + //
                        "JOIN junction_mahasiswa_jurusan AS jmj ON jmj.id_mahasiswa = m.nim";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            System.out.println("===============================");
            int temp = 1;
            while (result.next()) {
                String nim = result.getString("nim");
                String nama = result.getString("nama");
                String jurusan = result.getString("id_jurusan");

                System.out.println(temp + ". Mahasiswa: " + nama + " (" + nim + ") --> Jurusan: " + jurusan);
                temp++;
            }
            System.out.println("===============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String InputMahasiswa(String nama, String nim, String jurusan) {
        if (nama.equalsIgnoreCase("") || nim.equalsIgnoreCase("") || jurusan.equalsIgnoreCase("")) {
            return "Nama, NIM, Jurusan tidak boleh kosong!";
        }
        jurusan = jurusan.toUpperCase();
        String sql_checkJurusan = "SELECT kode FROM jurusan WHERE kode = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_checkJurusan);
            preparedStatement.setString(1, jurusan);
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {
                return "Jurusan dengan kode " + jurusan + " tidak ditemukan!";
            }

            String sql_insertMahasiswa = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)";
            PreparedStatement psInsert = conn.prepareStatement(sql_insertMahasiswa);
            psInsert.setString(1, nama);
            psInsert.setString(2, nim);
            psInsert.executeUpdate();

            String sql_insertJurusanMahasiswa = "INSERT INTO junction_mahasiswa_jurusan (id_mahasiswa,id_jurusan) VALUES (?, ?)";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql_insertJurusanMahasiswa);
            preparedStatement1.setString(1, nim);
            preparedStatement1.setString(2, jurusan.toUpperCase());
            preparedStatement1.executeUpdate();
            return "Input Mahasiswa " + nama + " Berhasil!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error saat input";
        }
    }
}
