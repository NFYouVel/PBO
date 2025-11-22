package uts.models;

public abstract class Vehicle {
    private BahanBakar bb;
    private int capacity;
    private String nama;

    public Vehicle(int capacity, String nama, BahanBakar bb){
        this.capacity = capacity;
        this.nama = nama;
        this.bb = bb;
    }

    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append(", Capacity : ").append(capacity);
        return str.toString();
    };

    public BahanBakar getBahanBakar(){
        return this.bb;
    }
    public String getNama(){
        return this.nama;
    }
    public int getCapacity(){
        return this.capacity;
    }
}
