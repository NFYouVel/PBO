package uts.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import uts.controllers.VehicleController;
import uts.models.BahanBakar;
import uts.models.Vehicle;
import uts.util.CLIUtil;

public class VehicleView {

    private VehicleController vehicleController;

    public void setVehicleController(VehicleController controller) {
        this.vehicleController = controller;
    }

    public void mainMenu() {
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
                vehicleController.printAll();
                break;
            case 3:
                handleSortCapacity();
                break;
            default:
                return;
        }

        mainMenu();
    }

    public void handleSortCapacity(){
        List<Vehicle> vehicle = new ArrayList()<>;
        Collection.sort(vehicle, new Comparator<Vehicle>(){
            public int compare(vehicle.get)
        })
    }

    public void handleInputVehicle() {
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
                BahanBakar inputBB = null;
                if (bahanBakar.equalsIgnoreCase("Avtur")) {
                    inputBB = BahanBakar.AVTUR;
                } else if (bahanBakar.equalsIgnoreCase("Diesel")) {
                    inputBB = BahanBakar.DIESEL;
                } else if (bahanBakar.equalsIgnoreCase("Bensin")) {
                    inputBB = BahanBakar.BENSIN;
                }
                int kapasitas_mobil = Integer.parseInt(CLIUtil.getString());

                vehicleController.addVehicle(kapasitas_mobil, nama, inputBB);
                break;
            case 2:
                int jumlahRoda = CLIUtil.getInt();
                vehicleController.addVehicle(nama, jumlahRoda);
                break;
            case 3:
                int kapasitas_heli = Integer.parseInt(CLIUtil.getString());
                int jumlahBalingBaling = Integer.parseInt(CLIUtil.getString());
                vehicleController.addVehicle(kapasitas_heli, nama, jumlahBalingBaling);
                break;
            case 4:
                int kapasitas_pesawat = Integer.parseInt(CLIUtil.getString());
                int jumlahroda = Integer.parseInt(CLIUtil.getString());
                boolean pesawattempur = CLIUtil.getBoolean();
                vehicleController.addVehicle(kapasitas_pesawat, nama, pesawattempur, jumlahroda);
                break;
        }
        mainMenu();
    }

    public void printAll(ArrayList<Vehicle> vehicleList) {
        for (Vehicle v : vehicleList) {
            v.getDetails();
        }
    }
}
