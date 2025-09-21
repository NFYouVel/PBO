package pertemuan2.repository;

// Library
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// Object
import pertemuan2.DatabaseConnection;
import pertemuan2.models.MataKuliah;
import pertemuan2.repository.JurusanRepository;

public class MataKuliahRepository {

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

    public static String InputJurusan(MataKuliah mk) {
        if (mk.kode.equals("") || mk.nama.equals("") || mk.sks == 0) {
            return "Kode atau Nama atau sks tidak boleh kosong!";
        } else {
            String sql = "INSERT INTO matakuliah (kode, nama, sks) VALUES (?, ?, ?)";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, mk.kode);
                preparedStatement.setString(2, mk.nama);
                preparedStatement.setInt(3, mk.sks);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return "Terjadi kesalahan saat input jurusan.";
            }
        }
        return "Input Mata Kuliah Berhasil!";
    }

    public static String DeleteMataKuliah() {
        ViewMataKuliah();
        System.out.println("Masukkan kode mata kuliah yang akan dihapus: ");
        String kode = sc.nextLine();

        String sql = "DELETE FROM matakuliah WHERE kode = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, kode);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return "Delete Mata Kuliah dengan kode " + kode + " berhasil!";
            } else {
                return "Tidak ada Mata Kuliah dengan kode " + kode + " yang ditemukan.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat menghapus Mata Kuliah.";
        }
    }

    public static void ViewMataKuliah() {
        String sql = "SELECT kode, nama, sks FROM matakuliah";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            System.out.println("===============================");
            int temp = 1;
            while (result.next()) {
                String kode = result.getString("kode");
                String nama = result.getString("nama");
                int sks = result.getInt("sks");

                System.out.println(temp + ". Kode: " + kode + ", Nama: " + nama + ", SKS: " + sks);
                temp++;
            }
            System.out.println("===============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String RelationMataKuliahJurusan() {
        JurusanRepository.ViewJurusan();
        System.out.println("Masukkan kode jurusan yang ingin di masukkan: ");
        String kode_jurusan = sc.nextLine();
        ViewMataKuliah();
        System.out.println("Masukkan kode mata kuliah kedalam " + kode_jurusan + ": ");
        String kode_mk = sc.nextLine();

        String sql = "INSERT INTO junction_jurusan_matakuliah (id_jurusan, id_matakuliah) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kode_jurusan);
            preparedStatement.setString(2, kode_mk);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat input jurusan.";
        }
        return "Berhasil input " + kode_jurusan + " ke dalam " + kode_mk + "!";
    }

}
