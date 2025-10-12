package minggu6.views.mahasiswa;

import minggu6.controller.MahasiswaController;
import minggu6.util.CLIUtil;

public class MahasiswaAddView {
    private MahasiswaController mahasiswaController;

    public void render(){
        System.out.println("Tambah Mahasiswa");
        System.out.print("NIM: ");
        String nim = CLIUtil.getString();
        System.out.print("Kode Jurusan: ");
        String kodeJurusan = CLIUtil.getString();
        System.out.print("Nama: ");
        String nama = CLIUtil.getString();
        System.out.print("Tempat Lahir: ");
        String tempatLahir = CLIUtil.getString();
        System.out.print("Tanggal Lahir: ");
        String tanggalLahir = CLIUtil.getString();
        System.out.print("Alamat: ");
        String alamat = CLIUtil.getString();
        System.out.print("No. Telepon: ");
        String noTelepon = CLIUtil.getString();

        mahasiswaController.add(nim, kodeJurusan, nama, tempatLahir, tanggalLahir, alamat, noTelepon);

        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
    }
}
