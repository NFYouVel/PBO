package uts.controllers;

import java.util.ArrayList;

import uts.models.BahanBakar;
import uts.models.Helikopter;
import uts.models.Mobil;
import uts.models.Pesawat;
import uts.models.Truk;
import uts.models.Vehicle;
import uts.models.repo.VehicleRepository;
import uts.views.VehicleView;

public class VehicleController {
    private VehicleRepository vehicleRepository;
    private VehicleView vehicleView;

    public VehicleController(VehicleRepository vehicleRepository, VehicleView vehicleView) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleView = vehicleView;
    }

    public void StartMenu(){
        vehicleView.mainMenu();
    }

    public void addVehicle (int capacity, String nama, BahanBakar bb){
        vehicleRepository.insertVehicle(new Mobil(capacity, nama, bb));
    }
    public void addVehicle (String nama, int jumlahRoda){
        vehicleRepository.insertVehicle(new Truk(nama, jumlahRoda));
    }
    public void addVehicle (int capacity, String nama, int jumlahBalingBaling){
        vehicleRepository.insertVehicle(new Helikopter(capacity, nama, jumlahBalingBaling));
    }
    public void addVehicle (int capacity, String nama, boolean isPesawatTempur, int sumRoda){
        vehicleRepository.insertVehicle(new Pesawat(capacity, nama, isPesawatTempur, sumRoda));
    }
    
     public void printAll(){
        ArrayList<Vehicle> vehicleList = vehicleRepository.getVehicleList();
        vehicleView.printAll(vehicleList);
    }
}
