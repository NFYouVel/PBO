package uts.models.repo;

import java.util.ArrayList;

import uts.models.Vehicle;

public class VehicleRepository {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public void insertVehicle(Vehicle vehicle){
        this.vehicleList.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicleList(){
        return this.vehicleList;
    }
}
