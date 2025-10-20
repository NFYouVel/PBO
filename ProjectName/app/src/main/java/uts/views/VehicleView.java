package uts.views;

import java.util.ArrayList;

import uts.controllers.VehicleController;
import uts.models.BahanBakar;
import uts.models.Vehicle;
import uts.util.CLIUtil;

public class VehicleView {
    private VehicleController vehicleController;

    public void setVehicleController(VehicleController controller){
        this.vehicleController = controller;
    }

    public void mainMenu(){
        StringBuilder str = new StringBuilder("Menu: \n");
        str.append("1. Tambah Vehicle\n");
        str.append("2. Tampilkan Semua Kendaraan\n");
        str.append("3. Urutkan kendaraan berdasarkan kapasitas\n");
        str.append("0. Keluar\n");

        int pilihan = CLIUtil.getInt();

        switch (pilihan) {
            case 1:
                handleInputVehicle();
                break;
            case 2:
                mahasiswaController.printAll();
                break;
            case 3:
                handleInputSarjana();
                break;
            case 4:
                handleInputMagister();
                break;
            default:
                return;
        }

        mainMenu();
    }

    public void handleInputVehicle(){
        StringBuilder str = new StringBuilder("Menu: \n");
        str.append("1. Tambah Mobil\n");
        str.append("2. Tambah Truk\n");
        str.append("3. Tambah Helikopter\n");
        str.append("4. Tambah Pesawat\n");
        str.append("0. Keluar\n");

        int pilihan = CLIUtil.getInt();
        
        String nama = CLIUtil.getString();
        switch (pilihan) {
            case 1:
                String bahanBakar = CLIUtil.getString();
                BahanBakar inputBB;
                if (bahanBakar.equalsIgnoreCase("Avtur")) {
                    inputBB = BahanBakar.AVTUR;
                } else if (bahanBakar.equalsIgnoreCase("Diesel")) {
                    inputBB = BahanBakar.DIESEL;
                } else if (bahanBakar.equalsIgnoreCase("Bensin")) {
                    inputBB = BahanBakar.BENSIN;
                }

                int kapasitas_mobil = Integer.parseInt(CLIUtil.getString());

                mahasiswaController.add
                break;
            case 2:
                int jumlahRoda = Integer.parseInt(CLIUtil.getString());

                break;
            case 3:
                int kapasitas_heli = Integer.parseInt(CLIUtil.getString());
                break;
            case 4:
                handleInputMagister();
                break;
            default:
                return;
        }

        mainMenu();
    }

    public void printAll(ArrayList<Vehicle> vehicleList){
        for(Vehicle v : vehicleList) {
            v.getDetails();
        } 
    }
}
