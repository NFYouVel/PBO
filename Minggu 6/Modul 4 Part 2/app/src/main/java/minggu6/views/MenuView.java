package minggu6.views;

import minggu6.controllers.MahasiswaController;
import minggu6.controllers.StaffController;
import minggu6.controllers.UserController;
import minggu6.models.User;
import minggu6.controllers.DosenController;
import minggu6.util.CLIUtil;
import minggu6.views.mahasiswa.MahasiswaView;

public class MenuView {

    // Mahasiswa Controller
    private UserController userController;
    private MahasiswaController mahasiswaController;
    private MahasiswaView mahasiswaView;
    private DosenController dosenController;
    private StaffController staffController;

    public MenuView() {
        this.mahasiswaView = new MahasiswaView();
        this.userController = new UserController();
        this.mahasiswaController = new MahasiswaController();
        this.dosenController = new DosenController();   
    }

    public void render() {
        System.out.println("Menu Modul 4 Part 2: ");
        System.out.println("1. Print UserData Berdasarkan Nama");
        System.out.println("2. Print NA untuk seorang mahasiswa");
        System.out.println("3. Print All Mahasiswa berdasarkan Kode MK");
        System.out.println("4. Check below minimum criteria");
        System.out.println("5. Print Total Presensi By NIM");
        System.out.println("6. Print Total Jam mengajar dosen");
        System.out.println("7. Print gaji seorang staff berdasarkan NIK");
        System.out.println("0. Exit");
        System.out.print("Pilih menu: ");
        int menu = CLIUtil.getInt();
        CLIUtil.getString();

        switch (menu) {
            case 1:
                handleMenuPrintUserData();
                break;
            case 2:
                handleMenuPrintNAMahasiswa();
                break;
            case 3:
                handleMenuPrintAllMahasiswaBasedOnKodeMK();
                break;  
            case 4:
                renderCheckBelowMinimumCriteria();
                break;
            case 5:
                handleMenuPrintTotalPresensiByNIM();
                break;
            case 6:
                handleMenuPrintTotalJamMengajarDosen();
                break;
            case 7:
                handleMenuPrintGajiStaff();
                break;
            default:
                return;
        }

        render();
    }
    private void handleMenuPrintGajiStaff() {
        System.out.print("Masukkan NIK Staff :");
        String input_nik = CLIUtil.getString();
        staffController.printGajiStaff(input_nik);
    }

    private void handleMenuPrintTotalJamMengajarDosen() {
        System.out.print("Masukkan NIK Dosen :");
        String input_nik = CLIUtil.getString();
        dosenController.printTotalJamMengajarDosen(input_nik);
    }

    private void handleMenuPrintTotalPresensiByNIM() {
        System.out.print("Masukkan NIM Mahasiswa :");
        String input_nim = CLIUtil.getString();
        mahasiswaController.printTotalPresensiByNIM(input_nim);
    }

    private void renderCheckBelowMinimumCriteria() {
        System.out.print("Masukkan kode MK untuk pengecekan below minimum criteria: ");
        String input_kode_mk = CLIUtil.getString();
        mahasiswaController.checkBelowMinimumCriteria(input_kode_mk);
    }

    private void handleMenuPrintAllMahasiswaBasedOnKodeMK() {
        System.out.print("Masukkan Kode MK :");
        String input_kode_mk = CLIUtil.getString();
        mahasiswaController.printNAAllMahasiswa(input_kode_mk);
    }

    private void handleMenuPrintUserData() {
        System.out.println();
        System.out.print("Masukkan nama yang akan dicari: ");
        String input_nama = CLIUtil.getString();
        for (User user : userController.printMenuByUserData(input_nama)) {
            System.out.println(user.toString());
        }
    }

    private void handleMenuPrintNAMahasiswa(){
        System.out.println();
        System.out.print("Masukkan NIM Mahasiswa :");
        String input_nim = CLIUtil.getString();
        
        System.out.print("Apakah Mahasiswa Doctor? (1. Ya / 0. Tidak) :");
        int isDoctor = CLIUtil.getInt();
        CLIUtil.getString();
        if (isDoctor == 0) {
            System.out.print("Masukkan Kode MK :");
            String input_kode_mk = CLIUtil.getString();
            mahasiswaController.printNAMahasiswa(input_nim, input_kode_mk);
        } else {
            mahasiswaController.printNAMahasiswa(input_nim);
        }

    }
}
