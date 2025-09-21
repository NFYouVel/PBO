package pertemuan2.repository;

// Library
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// Object
import pertemuan2.DatabaseConnection;
import pertemuan2.models.Jurusan;

public class JurusanRepository {

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

    public static String InputJurusan(Jurusan jurusan) {
        if (jurusan.kode.equals("") || jurusan.nama.equals("")) {
            return "Kode atau Nama tidak boleh kosong!";
        } else {
            String sql = "INSERT INTO jurusan (kode, nama) VALUES (?, ?)";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, jurusan.kode);
                preparedStatement.setString(2, jurusan.nama);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Input Jurusan Berhasil!";
    }

    public static void ViewJurusan() {
        String sql = "SELECT kode, nama FROM jurusan";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            System.out.println("===============================");
            int temp = 1;
            while (result.next()) {
                String kode = result.getString("kode");
                String nama = result.getString("nama");

                System.out.println(temp + ". Kode: " + kode + ", Nama: " + nama);
                temp++;
            }
            System.out.println("===============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String DeleteJurusan() {
        ViewJurusan();
        System.out.println("Masukkan kode jurusan yang akan dihapus: ");
        String kode = sc.nextLine();

        String sql = "DELETE FROM jurusan WHERE kode = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, kode);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return "Delete Jurusan dengan kode " + kode + " berhasil!";
            } else {
                return "Tidak ada Jurusan dengan kode " + kode + " yang ditemukan.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat menghapus Jurusan.";
        }
    }
}
