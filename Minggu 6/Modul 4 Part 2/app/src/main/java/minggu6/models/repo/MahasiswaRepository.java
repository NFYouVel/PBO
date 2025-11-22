package minggu6.models.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import minggu6.models.Mahasiswa;
import minggu6.util.connection;

public class MahasiswaRepository {
    private ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
    private static Connection conn;

    static {
        conn = connection.getConnection();
    }

    public void printTotalPresensiByNIM(String nim) {
        String sql = "SELECT * FROM matkul_ambil ma INNER JOIN presensi p ON p.matkul_ambil_id = ma.matkul_ambil_id WHERE ma.nim = ? ORDER BY ma.matkul_ambil_id ASC";

        try {
            ArrayList<String> presensiList = new ArrayList<>();
            ArrayList<Integer> totalPresensiList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();   
            
            String checkSameKodeMK = "";
            String beforeKodeMK = "";
            while (rs.next()) {
                checkSameKodeMK = rs.getString("kode_mk");
                if (!checkSameKodeMK.equals(beforeKodeMK)) {
                    presensiList.add(checkSameKodeMK);
                    if (rs.getInt("status") == 1) {
                        totalPresensiList.add(1);
                    } else {
                        totalPresensiList.add(0);
                        
                    }
                } else {
                    if (rs.getInt("status") == 1) {
                        totalPresensiList.set(totalPresensiList.size() - 1, totalPresensiList.get(totalPresensiList.size() - 1) + 1);
                    }
                }
                beforeKodeMK = checkSameKodeMK;
            }
            for (int i = 0; i < presensiList.size(); i++) {
                System.out.println("Total presensi mahasiswa dengan NIM " + nim + " pada mata kuliah " + presensiList.get(i) + " adalah: " + totalPresensiList.get(i));
            }
            System.out.println();   
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void checkBelowMinimumCriteria(String kode_mk) {
        String sql = "SELECT * FROM matkul_ambil WHERE kode_mk = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode_mk);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();   
            int temp_jumlahMhsTidakLolos = 0;
            int temp_jumlahMhs = 0;
            while (rs.next()) {
                double nilai1 = rs.getDouble("nilai_1");
                double nilai2 = rs.getDouble("nilai_2");
                double nilai3 = rs.getDouble("nilai_3");

                double na = (nilai1 + nilai2 + nilai3) / 3;  

                if (na < 56) {
                    temp_jumlahMhsTidakLolos++;
                }
                temp_jumlahMhs++;
            }
            System.out.println("<" + temp_jumlahMhsTidakLolos + "> dari <" + temp_jumlahMhs + "> mahasiswa tidak lulus matakuliah <" + kode_mk + ">");
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printNAFromAllMahasiswa(String kode_mk){ // View For Mahasiswa Non-Doctor
        String sql = "SELECT * FROM matkul_ambil WHERE kode_mk = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode_mk);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();   
            double temp_NA = 0;
            double temp_jumlahMhs = 0;
            while (rs.next()) {
                double nilai1 = rs.getDouble("nilai_1");
                double nilai2 = rs.getDouble("nilai_2");
                double nilai3 = rs.getDouble("nilai_3");

                double na = (nilai1 + nilai2 + nilai3) / 3;  
                temp_NA += na;
                temp_jumlahMhs++;
            }
            double final_NA = Math.round((temp_NA / temp_jumlahMhs) * 100.0) / 100.0;
            System.out.println("Nilai Akhir Rata-Rata Mahasiswa pada Mata Kuliah " + kode_mk + " adalah: " + final_NA);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printNAFromOneMahasiswa(String nim, String kode_mk){ // View For Mahasiswa Non-Doctor
        String sql = "SELECT * FROM matkul_ambil WHERE nim = ? AND kode_mk = ? LIMIT 1";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.setString(2, kode_mk);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();   
            if (rs.next()) {
                int nilai1 = rs.getInt("nilai_1");
                int nilai2 = rs.getInt("nilai_2");
                int nilai3 = rs.getInt("nilai_3");

                double na = (nilai1 + nilai2 + nilai3) / 3;
                System.out.println("Nilai Akhir Mahasiswa dengan NIM " + nim + " pada Mata Kuliah " + kode_mk + " adalah: " + na);
            }
            else {
                System.out.println("Data Mahasiswa dengan NIM " + nim + " pada Mata Kuliah " + kode_mk + " tidak ditemukan.");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void printNAFromOneMahasiswa(String nim){ // View For Mahasiswa Doctor
         String sql = "SELECT * FROM mahasiswa_dokter WHERE nim = ? LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();   
            if (rs.next()) {
                int sidang1 = rs.getInt("sidang_1");
                int sidang2 = rs.getInt("sidang_2");
                int sidang3 = rs.getInt("sidang_3");

                double na = (sidang1 + sidang2 + sidang3) / 3;
                System.out.println("Nilai Akhir Mahasiswa Doctor dengan NIM " + nim + " adalah: " + na);
            }
            else {
                System.out.println("Data Mahasiswa Doctor dengan NIM " + nim + " tidak ditemukan.");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
