package minggu6.views.mahasiswa;

import minggu6.util.CLIUtil;

public class MahasiswaView {

    public void render() {
        System.out.println("Menu Mahasiswa");
        System.out.println("1. Lihat daftar Mahasiswa");
        System.out.println("2. Tambah Mahasiswa");
        System.out.println("3. Update Mahasiswa");
        System.out.println("4. Hapus Mahasiswa");
        System.out.println("0. Kembali ke menu utama");

    }

    private void handleMenuInput() {
        int menuInput = CLIUtil.getInt();
        switch (menuInput) {
            case 2:

                break;
        }
    }

}
