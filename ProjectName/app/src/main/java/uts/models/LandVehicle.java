package uts.models;

public abstract class LandVehicle extends Vehicle{
    private int jumlahRoda;
    public LandVehicle(int capacity, String nama, BahanBakar bb, int jumlahRoda) {
        super(capacity, nama, bb);
        this.jumlahRoda = jumlahRoda;
    }

    

    public int getJumlahRoda() {
        return this.jumlahRoda;
    } 
}
