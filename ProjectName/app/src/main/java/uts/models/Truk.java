package uts.models;

public class Truk extends LandVehicle implements Kargoable{
    public Truk(String nama, int sumRoda){
        super(3, nama, BahanBakar.DIESEL, sumRoda);
    }

    @Override
    public String getDetails(){
        return "Truk " + super.getNama() + super.getDetails() + ", Jumlah Roda: " + super.getJumlahRoda();
    }

    @Override
    public void loadKargo() {
        System.out.println("Telah melakukan load kargo di ...");
    }

    @Override
    public void unloadKargo() {
        System.out.println("Telah melakukan unload kargo di ...");
    }
}
