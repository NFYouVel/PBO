package uts.models;

public class Helikopter extends SkyVehicle {
    int jumlahBalingBaling;
    public Helikopter(int capacity, String nama, int jumlahBalingBaling){
        super(capacity, nama, BahanBakar.AVTUR);
        this.jumlahBalingBaling = jumlahBalingBaling;
    }
}
