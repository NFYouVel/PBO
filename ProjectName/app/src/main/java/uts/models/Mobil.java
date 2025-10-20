package uts.models;

public class Mobil extends LandVehicle {
    public Mobil(int capacity, String nama, BahanBakar bb) {
        super(capacity, nama, bb, 4);
    }

    @Override
    public String getDetails(){
        return "Mobil " + super.getNama() + super.getDetails() + ", Jumlah Roda: " + super.getJumlahRoda();
    }
}
